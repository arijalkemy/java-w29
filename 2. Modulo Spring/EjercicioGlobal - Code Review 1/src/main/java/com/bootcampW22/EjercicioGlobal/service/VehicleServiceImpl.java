package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageCapacityDto;
import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.VehicleAlreadyExistsException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService {

    IVehicleRepository vehicleRepository;
    ObjectMapper mapper = new ObjectMapper();

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public ResponseDto addVehicles(VehicleDto vehicle) {

        if (vehicleRepository.existById(vehicle.getId())) {
            throw new VehicleAlreadyExistsException("Identificador del vehículo ya existente.");
        }
        vehicleRepository.save(mapper.convertValue(vehicle, Vehicle.class));
        return new ResponseDto("Vehículo creado exitosamente");
    }

    @Override
    public List<VehicleDto> searchVehiclesByBrandAndYears(String brand, int startYears, int endYears) {

        List<Vehicle> vehicleList = vehicleRepository.findByBrand(brand);
        List<VehicleDto> vehicleDtoList = vehicleList.stream()
                .filter(v -> v.getYear() >= startYears && v.getYear() <= endYears)
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .collect(Collectors.toList());
        if (vehicleList.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }

        return vehicleDtoList;
    }

    @Override
    public AverageSpeedDto averageSpeedByBrand(String brand) {
        List<Vehicle> vehiclesBrand = vehicleRepository.findByBrand(brand);

        if (vehiclesBrand.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }

        Double avgSpeed = vehiclesBrand.stream()
                .mapToDouble(Vehicle::getMax_speed)
                .average()
                .orElse(0.0);

        return new AverageSpeedDto(brand, avgSpeed);
    }

    @Override
    public ResponseDto addBatchVehicles(List<VehicleDto> vehicles) {
        vehicles.forEach(vr -> {
            if (vehicleRepository.existById(vr.getId())) {
                throw new VehicleAlreadyExistsException("Identificador del vehículo ya existente.");
            }
            vehicleRepository.save(mapper.convertValue(vr, Vehicle.class));
        });
        return new ResponseDto("Vehiculos creados exitosamente");
    }

    @Override
    public ResponseDto updateSpeed(Long id, Double speed) {

        if (!vehicleRepository.existById(id)) {
            throw new NotFoundException("No se encontro el vehiculo.");
        }

        vehicleRepository.updateSpeed(id, speed);
        return new ResponseDto("Velocidad del vehículo actualizada exitosamente");
    }

    @Override
    public List<VehicleDto> getVehiclesByFuel(String type) {
        List<Vehicle> vehiclesByFuel = vehicleRepository.findByFuel(type);

        if (vehiclesByFuel.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehiclesByFuel.stream().map(v -> mapper.convertValue(v,VehicleDto.class)).toList();

    }

    @Override
    public ResponseDto deleteVehicle(Long id) {

        if (!vehicleRepository.existById(id)) {
            throw new NotFoundException("No se encontro el vehiculo.");
        }

        if (vehicleRepository.delete(id)) {
            return new ResponseDto("Vehiculo eliminado exitosamente");
        } else {
            return new ResponseDto("El vehiculo no pude ser eliminado correctamente");
        }
    }

    @Override
    public List<VehicleDto> getVehiclesByTransmission(String type) {
        List<Vehicle> vehiclesByTransmission = vehicleRepository.findByTransmission(type);

        if (vehiclesByTransmission.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehiclesByTransmission.stream().map(v -> mapper.convertValue(v,VehicleDto.class)).toList();
    }

    @Override
    public ResponseDto updateFuel(Long id, String fuel) {

        if (!vehicleRepository.existById(id)) {
            throw new NotFoundException("No se encontro el vehiculo.");
        }

        vehicleRepository.updateFuel(id, fuel);
        return new ResponseDto("Velocidad del vehículo actualizada exitosamente");
    }

    @Override
    public AverageCapacityDto averageCapacityByBrand(String brand) {
        List<Vehicle> vehiclesBrand = vehicleRepository.findByBrand(brand);

        if (vehiclesBrand.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }

        Double avgCapacity = vehiclesBrand.stream()
                .mapToDouble(Vehicle::getPassengers)
                .average()
                .orElse(0.0);

        return new AverageCapacityDto(brand, avgCapacity);
    }

    @Override
    public List<VehicleDto> getVehiclesByDimensions(String length, String width) {
        String[] rangeLength = length.split("-");
        String[] rangeWidth = width.split("-");

        Integer minL = Integer.parseInt(rangeLength[0]);
        Integer maxL = Integer.parseInt(rangeLength[1]);
        Integer minW = Integer.parseInt(rangeWidth[0]);
        Integer maxW = Integer.parseInt(rangeWidth[1]);

        List<Vehicle> vehicles = vehicleRepository.vehiclesByDimension(minL, maxL,maxW, minW );

        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

    }

    @Override
    public List<VehicleDto> getVehiclesByWeight(Integer minWeight, Integer maxWeight) {

        List<Vehicle> vehicles = vehicleRepository.vehiclesByWeight(minWeight, maxWeight );

        return vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();
    }
}
