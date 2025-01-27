package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.IdAlreadyInUseException;
import com.bootcampW22.EjercicioGlobal.exception.InvalidVehicleDataException;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements IVehicleService{

    IVehicleRepository vehicleRepository;

    public VehicleServiceImpl(VehicleRepositoryImpl vehicleRepository){
        this.vehicleRepository = vehicleRepository;
    }
    @Override
    public List<VehicleDto> searchAllVehicles() {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No se encontró ningun auto en el sistema.");
        }
        return vehicleList.stream()
                .map(v -> mapper.convertValue(v,VehicleDto.class))
                .collect(Collectors.toList());
    }

    @Override
    public VehicleDto addNewVehicle(VehicleDto newVehicle) {
        ObjectMapper mapper = new ObjectMapper();
        validateNewVehicleData(newVehicle);
        VehicleDto existingVehicle = mapper.convertValue(vehicleRepository.findById(newVehicle.getId()), VehicleDto.class);
        if (existingVehicle != null) {
            throw new IdAlreadyInUseException(newVehicle.getId());
        }
        return mapper.convertValue(vehicleRepository.save(mapper.convertValue(newVehicle, Vehicle.class)), VehicleDto.class);
    }

    private void validateNewVehicleData(VehicleDto newVehicle) {
        Field[] data = newVehicle.getClass().getDeclaredFields();
        for (Field field: data) {
            if (field == null) {
                throw new InvalidVehicleDataException();
            }
        }
    }
}
