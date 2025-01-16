package com.bootcampW22.code_review.service;

import com.bootcampW22.code_review.dto.ExceptionDto;
import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.dto.request.UpdateVehicleDto;
import com.bootcampW22.code_review.dto.response.ResponseVehicleDto;
import com.bootcampW22.code_review.entity.Vehicle;
import com.bootcampW22.code_review.exception.NotFoundException;
import com.bootcampW22.code_review.exception.VehicleAlreadyExistsException;
import com.bootcampW22.code_review.repository.IVehicleRepository;
import com.bootcampW22.code_review.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }

    @Override
    public List<VehicleDto> searchAllVehicles() {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream().map(v -> toDto(v)).toList();
    }

    @Override
    public ResponseVehicleDto addVehicles(List<VehicleDto> newVehicles) {
        newVehicles.forEach(v -> checkVehicleId(v));
        newVehicles.forEach(v -> vehicleRepository.addVehicle(toEntity(v)));
        return new ResponseVehicleDto("Se crearon satisfactoriamente los vehículos con ids: " +
                newVehicles.stream().map(v -> v.getId().toString()).collect(Collectors.joining(", ")));
    }

    @Override
    public ResponseVehicleDto addVehicle(VehicleDto newVehicle) {
        checkVehicleId(newVehicle);
        vehicleRepository.addVehicle(toEntity(newVehicle));
        return new ResponseVehicleDto("Se creó satisfactoriamente el vehículo con id: " + newVehicle.getId());
    }

    @Override
    public VehicleDto getVehicleById(Long id) {
        Optional<Vehicle> oVehicle = vehicleRepository.getById(id);
        if(oVehicle.isEmpty()){
            throw new NotFoundException("No se encontró el vehículo con id: " + id);
        }
        return toDto(oVehicle.get());
    }

    @Override
    public List<VehicleDto> getByColorAndYear(String color, Integer year) {
        List<Vehicle> vehicles = vehicleRepository.getByColorAndYear(color, year);
        return checkList(vehicles);
    }

    @Override
    public List<VehicleDto> getByBrandAndBetweenYears(String brand, Integer startYear, Integer endYear) {
        List<Vehicle> vehicles = vehicleRepository.getByBrandAndBetweenYears(brand, startYear, endYear);
        return checkList(vehicles);
    }

    @Override
    public List<VehicleDto> getByWeight(double weightMin, double weightMax) {
        List<Vehicle> vehicles = vehicleRepository.getByWeight(weightMin, weightMax);
        return checkList(vehicles);
    }

    @Override
    public List<VehicleDto> getByDimensions(double minLength, double maxLength, double minWidth, double maxWidth) {
        List<Vehicle> vehicles = vehicleRepository.getByDimensions(minLength, maxLength, minWidth, maxWidth);
        return checkList(vehicles);
    }

    @Override
    public ResponseVehicleDto updateFuel(Long id, UpdateVehicleDto vehicleNewFeatures) {
        vehicleRepository.updateFuel(toEntity(getVehicleById(id)), vehicleNewFeatures.getFuel_type());
        return new ResponseVehicleDto(
                String.format("El tipo de combustible del vehículo %d fue actualizado exitosamente.", id));
    }

    @Override
    public ResponseVehicleDto getAverageCapacityByBrand(String brand) {
        Double averageCapacity = vehicleRepository.getAverageCapacityByBrand(brand);
        return new ResponseVehicleDto(
                String.format("La capacidad promedio de personas de los vehículos %s es %d.", brand, averageCapacity));
    }

    // MÉTODOS AUXILIARES
    private void checkVehicleId(VehicleDto newVehicle) {
        Optional<Vehicle> oVehicle = vehicleRepository.getById(newVehicle.getId());
        if(oVehicle.isPresent()){
            throw new VehicleAlreadyExistsException(newVehicle.getId());
        }
    }

    private List<VehicleDto> checkList(List<Vehicle> vehicles){
        if(vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos que cumplan con los criterios indicados.");
        }
        return vehicles.stream().map(v -> toDto(v)).toList();
    }

    private VehicleDto toDto(Vehicle vehicle){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicle, VehicleDto.class);
    }

    private Vehicle toEntity(VehicleDto vehicleDto){
        ObjectMapper mapper = new ObjectMapper();
        return mapper.convertValue(vehicleDto, Vehicle.class);
    }
}
