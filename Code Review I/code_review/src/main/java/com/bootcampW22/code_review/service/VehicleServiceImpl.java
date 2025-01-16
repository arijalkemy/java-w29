package com.bootcampW22.code_review.service;

import com.bootcampW22.code_review.dto.ExceptionDto;
import com.bootcampW22.code_review.dto.VehicleDto;
import com.bootcampW22.code_review.dto.response.NewVehicleDto;
import com.bootcampW22.code_review.entity.Vehicle;
import com.bootcampW22.code_review.exception.NotFoundException;
import com.bootcampW22.code_review.exception.VehicleAlreadyExistsException;
import com.bootcampW22.code_review.repository.IVehicleRepository;
import com.bootcampW22.code_review.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
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
    public NewVehicleDto addVehicle(VehicleDto newVehicle) {
        Optional<Vehicle> oVehicle = vehicleRepository.getById(newVehicle.getId());
        if(oVehicle.isPresent()){
            throw new VehicleAlreadyExistsException(newVehicle.getId());
        }
        vehicleRepository.addVehicle(toEntity(newVehicle));
        return new NewVehicleDto(newVehicle.getId());
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
