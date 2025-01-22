package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.ResponseDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.ConflicException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public Vehicle addVehicle(VehicleDto vehicleDto) {
        Optional<Vehicle> vehicle = vehicleRepository.findVehicleById(vehicleDto.getId());
        if (vehicle.isPresent()) {
            throw new ConflicException("Identificador del vehículo ya existente.");
        }
        return vehicleRepository.addVehicle(mapper.convertValue(vehicleDto, Vehicle.class));
    }

    @Override
    public Optional<VehicleDto> findVehicleById(Long id) {
        Optional<Vehicle> vehicle = vehicleRepository.findVehicleById(id);
        return vehicle.map(v -> mapper.convertValue(v, VehicleDto.class));
    }

    @Override
    public List<VehicleDto> getVehicleByColorAndYear(String color, int year) {
        List<Vehicle> vehicle = vehicleRepository.getVehicleByColorAndYear(color, year);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicle.stream().map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public List<VehicleDto> getVehicleByBrandAndYears(String brand, int starYear, int endYear) {
        List<Vehicle> vehicle = vehicleRepository.getVehicleByBrandAndYears(brand, starYear, endYear);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esos criterios.");
        }
        return vehicle.stream().map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public Double getSpeedByBrand(String brand) {
        Double valor = vehicleRepository.getAverageSpeedByBrand(brand);
        if (valor == 0.0) {
            throw new NotFoundException("No se encontraron vehículos de esa marca");
        }
        return valor;
    }

    @Override
    public List<VehicleDto> addAllVehicles(List<VehicleDto> vehicleDtos) {
        for (VehicleDto vehicleDto : vehicleDtos) {
            if (vehicleDto.getId() != null && vehicleRepository.findVehicleById(vehicleDto.getId()).isPresent()) {
                throw new ConflicException("Algún vehículo tiene un identificador ya existente.\n");
            }
        }

        List<Vehicle> vehicles = vehicleDtos.stream()
                .map(dto -> mapper.convertValue(dto, Vehicle.class))
                .toList();

        vehicles = vehicleRepository.addAllVehicles(vehicles);

        return vehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public VehicleDto updateSpeed(Long id, Double newSpeed) {
        Optional<Vehicle> vehicle = vehicleRepository.findVehicleById(id);
        if (vehicle.isEmpty()) {
            throw new NotFoundException("No se encontró el vehículo.");
        }
        if (newSpeed <= 0) {
            throw new ConflicException("Velocidad mal formada o fuera dde rango");
        }


        Vehicle vehicles = vehicleRepository.updateSpeed(id, newSpeed);

        return mapper.convertValue(vehicles, VehicleDto.class);
    }

    @Override
    public List<VehicleDto> getVehicleByFuel(String fuel) {

        List<Vehicle> vehicles = vehicleRepository.findVehicleByFuel(fuel);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con ese tipo de combustible.");
        }

        return vehicles.stream()
                .map(v -> mapper.convertValue(v, VehicleDto.class))
                .toList();
    }

    @Override
    public ResponseDto deleteById(Long id) {

        Boolean confirm = vehicleRepository.deleteVehicle(id);
        if (confirm) {
            return new ResponseDto("Vehículo eliminado exitosamente.");
        } else {
            throw new NotFoundException("No se encontró el vehículo");
        }
    }

    @Override
    public List<VehicleDto> findByTrasmissionType(String trasmisison) {

        List<Vehicle> vehicles = vehicleRepository.findByTrasmissionType(trasmisison);
        if(vehicles.isEmpty())
        {
            throw  new NotFoundException("No se encontraron vehículos con ese tipo de transmisión");
        }
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public ResponseDto updateFuel(Long id, String fuel) {
        Optional<Vehicle> vehicleDto = vehicleRepository.findVehicleById(id);

        if(vehicleDto.isEmpty())
        {
            throw  new NotFoundException("No se encontró el vehículo.");
        }

            Boolean vehicle = vehicleRepository.updateFuel(id,fuel);
        if (vehicle)
        {
            return  new ResponseDto("Tipo de combustible del vehículo actualizado exitosamente");
        }

        return  mapper.convertValue(vehicle,ResponseDto.class);
    }

    @Override
    public List<VehicleDto> findByMedidas(Double minWidth, Double maxWidth, Double minHeight, Double maxHeight) {
        if (minWidth == null || maxWidth == null || minHeight == null || maxHeight == null) {
            throw new IllegalArgumentException("Las dimensiones no pueden ser nulas.");
        }

        List<Vehicle> vehicles = vehicleRepository.findByDimensiones(minWidth, maxWidth, minHeight, maxHeight);

        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos que coincidan con las dimensiones especificadas.");
        }

        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle, VehicleDto.class))
                .toList();
    }

    @Override
    public Double avgPersonByBrand(String brand) {
        Double valor = vehicleRepository.avgPersonByBrand(brand);
        if (valor == 0.0)
        {
            throw  new NotFoundException(": No se encontraron vehículos de esa marca.");
        }
        return  valor;
    }

    @Override
    public List<VehicleDto> getVehicleByWeight(Double minWeight, Double maxWeight) {

        List<Vehicle> vehicles = vehicleRepository.getVehicleByWeight(minWeight,maxWeight);
        if (vehicles.isEmpty())
        {
            throw  new NotFoundException("No se encontraron vehículos en ese rango de peso.");
        }

        return  vehicles.stream().map(v -> mapper.convertValue(v, VehicleDto.class)).toList();

    }


}


