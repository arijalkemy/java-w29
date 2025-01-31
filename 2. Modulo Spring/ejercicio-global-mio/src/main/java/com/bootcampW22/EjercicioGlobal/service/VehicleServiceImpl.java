package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDTO;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDTO;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.*;
import com.bootcampW22.EjercicioGlobal.mapper.VehicleMapper;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.bootcampW22.EjercicioGlobal.utils.ReflectiveChecker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.function.Predicate;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public ResponseEntity<List<VehicleDTO>> findAll(String brand, String color, Integer since, Integer to, Integer year, String fuelType, String transmission, Double minLength, Double maxLength, Double minWidth, Double maxWidth, Double minWeight, Double maxWeight) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        if (vehicles.isEmpty()) return ResponseEntity.noContent().build();
        Map<Object, Predicate<VehicleDTO>> filterMap = createMap(brand, color, since, to, year, fuelType, transmission, minLength, maxLength, minWidth, maxWidth, minWeight, maxWeight);
        List<VehicleDTO> vehiclesDTO = vehiclesToDTO(vehicles);

        for (Map.Entry<Object, Predicate<VehicleDTO>> entry : filterMap.entrySet()) {
            if(checkExistence(entry.getKey())) vehiclesDTO = filterVehicles(vehiclesDTO, entry.getValue());
        }

        if (vehiclesDTO.isEmpty()) throw new NotFoundException("No hay resultados para los filtros seleccionados.");

        return ResponseEntity.ok(vehiclesDTO);
    }

    @Override
    public ResponseEntity<VehicleDTO> addVehicle(VehicleDTO vehicleDTO) {
        List<String> errors = checkVehicleProperties(vehicleDTO);
        if (!errors.isEmpty()) throw new AddVehicleException("No se puede agregar el vehículo", errors);
        if (vehicleExists(vehicleDTO.getId())) throw new ConflictException("Ya se encuentra registrado un vehículo con ese id.");
        Vehicle vehicle = VehicleMapper.dtoToVehicle(vehicleDTO);
        vehicleRepository.addVehicle(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED.value()).body(vehicleDTO);
    }

    @Override
    public ResponseEntity<List<VehicleDTO>> addVehicle(List<VehicleDTO> vehiclesDTO) {
        if (checkVehicleProperties(vehiclesDTO)) throw new BadRequestException("Alguno de los elementos no es correcto. Se necesita enviar todos los atributos.");
        if (vehicleExists(vehiclesDTO)) throw new ConflictException("Alguno/s de los vehículos ya se encuentra registrado.");
        List<Vehicle> vehicles = dtoToVehicle(vehiclesDTO);
        addVehicles(vehicles);
        return ResponseEntity.status(201).body(vehiclesDTO);
    }

    @Override
    public ResponseEntity<List<AverageSpeedDTO>> getAverageSpeed(String brands) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<String> brandsList;
        if (brands != null) brandsList = getBrands(brands);
        else brandsList = getBrands(vehicles);
        List<AverageSpeedDTO> averageSpeedList = getAverageSpeed(vehicles, brandsList);
        if (averageSpeedList.isEmpty()) throw new NotFoundException("La/s marca/s que envió no se encuentra/n en nuestra base de datos.");

        return ResponseEntity.ok(averageSpeedList);
    }

    @Override
    public ResponseEntity<List<AverageCapacityDTO>> getAverageCapacity(String brands) {
        List<Vehicle> vehicles = vehicleRepository.findAll();
        List<String> brandsList;
        if (brands != null) brandsList = getBrands(brands);
        else brandsList = getBrands(vehicles);

        List<AverageCapacityDTO> averageCapacity = returnAverageCapacity(brandsList, vehicles);
        if (averageCapacity.isEmpty()) throw new NotFoundException("La/s marca/s que envió no se encuentra/n en nuestra base de datos.");
        return ResponseEntity.ok(averageCapacity);
    }

    @Override
    public ResponseEntity<VehicleDTO> updateVehicle(Long id, VehicleDTO vehicleDTO) {
        int index = vehicleRepository.getVehicleIndex(id);
        if (index == -1) throw new NotFoundException("No existe un vehículo con ese id");
        Vehicle vehicle = updateVehicle(index, vehicleDTO);
        VehicleDTO updatedVehicle = VehicleMapper.vehicleToDto(vehicle);
        return ResponseEntity.status(HttpStatus.CREATED).body(updatedVehicle);
    }

    @Override
    public ResponseEntity<VehicleDTO> deleteVehicle(Long id) {
        Integer index = vehicleRepository.getVehicleIndex(id);
        if (index == -1) throw new NotFoundException("No existe un vehículo con ese id");
        Vehicle vehicle = vehicleRepository.deleteVehicle(index);;
        if (vehicle == null) throw new InternalServerException("Ocurrió un error al eliminar el vehiculo");
        VehicleDTO vehicleDTO = VehicleMapper.vehicleToDto(vehicle);
        return ResponseEntity.ok(vehicleDTO);
    }








    private Vehicle updateVehicle (Integer index, VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findByIndex(index);
        ReflectiveChecker.setProperties(vehicle, vehicleDTO, this::checkExistence);
        vehicleRepository.updateVehicle(index, vehicle);
        return vehicle;
    }

    private List<String> getBrands(String brands) {
        return Arrays.stream(brands.replaceAll(", ", ",").split(",")).toList();
    }
    private List<String> getBrands(List<Vehicle> vehicles) {
        return vehicles
                .stream()
                .map(Vehicle::getBrand)
                .distinct()
                .toList();
    }

    private List<AverageCapacityDTO> returnAverageCapacity (List<String> brands, List<Vehicle> vehicles) {
        List<AverageCapacityDTO> averageCapacityList = new ArrayList<>();
        for (String brand : brands) {
            double averageCapacity = vehicles
                    .stream()
                    .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                    .mapToDouble(v -> (double) v.getPassengers())
                    .average()
                    .orElse(0.0);
            if (averageCapacity != 0.0) averageCapacityList.add(new AverageCapacityDTO(brand, averageCapacity));
        }
        return averageCapacityList;
    }

    private List<AverageSpeedDTO> getAverageSpeed(List<Vehicle> vehicles, List<String> brands) {
        List<AverageSpeedDTO> averageSpeedlist = new ArrayList<>();
        for (String brand: brands) {
            double averageSpeed =vehicles
                    .stream()
                    .filter(v -> v.getBrand().equalsIgnoreCase(brand))
                    .mapToDouble(v -> Double.parseDouble(v.getMax_speed()))
                    .average()
                    .orElse(0.0);
            if (averageSpeed != 0.0) averageSpeedlist.add(new AverageSpeedDTO(brand, averageSpeed));
        }
        return averageSpeedlist;
    }

    private boolean checkExistence(Object item) {
        if (item == null) return false;
        if (item instanceof String str) return !str.trim().isEmpty();
        if (item instanceof Number num) return num.doubleValue() > 0;
        return false;
    }

    private List<VehicleDTO> filterVehicles (List<VehicleDTO> vehiclesDTO, Predicate<VehicleDTO> predicate) {
        return vehiclesDTO
                .stream()
                .filter(predicate)
                .toList();
    }

    private void addVehicles(List<Vehicle> vehicles) {
        vehicles
                .forEach(vehicleRepository::addVehicle);
    }

    private List<Vehicle> dtoToVehicle (List<VehicleDTO> vehiclesDTO) {
        return vehiclesDTO
                .stream()
                .map(VehicleMapper::dtoToVehicle)
                .toList();
    }

    private List<VehicleDTO> vehiclesToDTO(List<Vehicle> vehicles) {
        return vehicles
                .stream()
                .map(VehicleMapper::vehicleToDto)
                .toList();
    }

    private Boolean vehicleExists(List<VehicleDTO> vehiclesDTO) {
        return vehiclesDTO
                .stream()
                .anyMatch(v -> vehicleExists(v.getId()));
    }

    private Boolean vehicleExists(Long id) {
        return vehicleRepository
                .findAll()
                .stream()
                .anyMatch(v -> v.getId().equals(id));
    }

    private Boolean checkVehicleProperties (List<VehicleDTO> vehiclesDTO) {
        return vehiclesDTO
                .stream()
                .anyMatch(v -> !checkVehicleProperties(v).isEmpty());
    }

    private List<String> checkVehicleProperties(VehicleDTO vehicleDTO) {
        return ReflectiveChecker.checkProperties(vehicleDTO, this::checkExistence);
    }

    private Map<Object, Predicate<VehicleDTO>> createMap(String brand, String color, Integer since, Integer to, Integer year, String fuelType, String transmission, Double minLength, Double maxLength, Double minWidth, Double maxWidth, Double minWeight, Double maxWeight) {
        return new HashMap<>() {{
            put(brand, v -> v.getBrand().equalsIgnoreCase(brand));
            put(color, v -> v.getColor().equalsIgnoreCase(color));
            put(since, v -> v.getYear() >= since);
            put(to, v -> v.getYear() <= to);
            put(year, v -> v.getYear() == year);
            put(fuelType, v -> v.getFuel_type().equalsIgnoreCase(fuelType));
            put(transmission, v -> v.getTransmission().equalsIgnoreCase(transmission));
            put(minLength, v -> v.getHeight() >= minLength);
            put(maxLength, v -> v.getHeight() <= maxLength);
            put(minWidth, v -> v.getWidth() >= minWidth);
            put(maxWidth, v -> v.getWidth() <= maxWidth);
            put(minWeight, v -> v.getWeight() >= minWeight);
            put(maxWeight, v -> v.getWeight() <= maxWeight);
        }};
    }
}
