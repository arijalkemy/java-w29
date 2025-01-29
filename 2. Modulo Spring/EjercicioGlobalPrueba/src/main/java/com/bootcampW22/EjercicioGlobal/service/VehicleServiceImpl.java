package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.exception.ConflictException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    public void addVehicle(Vehicle vehicle) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();
        for(Vehicle v: vehicleList){
            if(Objects.equals(vehicle.getId(), v.getId())){
                throw new ConflictException("El vehiculo ya existe en el sistema.");
            }
        }
        vehicleRepository.addVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getByColorYear(String color,Integer year){
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> vehicleList2 = vehicleList.stream().filter(vehicle -> vehicle.getColor().equals(color) && vehicle.getYear() == year).toList();

        if (vehicleList2.isEmpty()){
            throw new NotFoundException("vehiculo no encontrado");
        }

        return vehicleList2;
    }

    @Override
    public Integer getVelocityByBrand( String brand){
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Integer> velocities = vehicleList.stream().filter(vehicle -> vehicle.getBrand().equals(brand)).map(Vehicle::getMax_speed).map(Integer::parseInt).toList();

        Integer sum = velocities.stream().reduce(0, Integer::sum);
        Integer sum2 = velocities.stream().reduce(0,Integer::sum);
        Integer cant = velocities.size();

        if (velocities.isEmpty()){
            throw new NotFoundException("no se encontraron vehiculos con esa marca.");
        }

        return sum/cant;
    }

    @Override
    public List<Vehicle> addBatchVehicles(List<Vehicle> vehicles){
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        List<Vehicle> idNulls = vehicles.stream().filter(vehicle -> Objects.equals(vehicle.getId(), null)).toList();

        if(!idNulls.isEmpty()){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Falta un id del vehiculo.");
        }

        for(Vehicle v: vehicles){
            for(Vehicle v2: vehicleList){
                if(Objects.equals(v.getId(), v2.getId())){
                    throw new ConflictException("El vehiculo ya existe en el sistema.");
                }
            }
        }

        vehicleRepository.addBatch(vehicles);
        return vehicleList;
    }

    @Override
    public void updateSpeed(Long id, String speed) {
        List<Vehicle> vehicleList = vehicleRepository.findAll();

        Boolean exists = false;
        Integer speedInt =Integer.parseInt(speed);

        Vehicle vehicle = vehicleRepository.findById(id);


        if(vehicle == null){
            throw new NotFoundException("No se encontro el vehiculo para actualizar.");
        }

        if(speedInt == 0 || speedInt < 0 || speedInt > 300){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Error en la velocidad del vehiculo.");
        }

        vehicleRepository.editVehicle(vehicle);
    }

    @Override
    public List<Vehicle> getFuelType(String type) {
        List<Vehicle> vehicles = vehicleRepository.getFuelType(type);
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontro ningun vehiculo con ese tipo de combustible");
        }
        return vehicles;
    }

    @Override
    public void deleteVehicle(Long id) {
        vehicleRepository.deleteVehicle(id);
    }

    @Override
    public List<VehicleDto> dimensionVehicle(String length, String width) {
        String[] widths = width.split("-");
        String[] lengths = length.split("-");
        Double min_length = Double.parseDouble(lengths[0]);
        Double max_length = Double.parseDouble(lengths[1]);
        Double min_width = Double.parseDouble(widths[0]);
        Double max_width = Double.parseDouble(widths[1]);

        ObjectMapper om = new ObjectMapper();

        List<Vehicle> vehiclesTransform= vehicleRepository.dimensionVehicle(min_length,max_length,min_width,max_width);
        return vehiclesTransform.stream().map(vehicle -> om.convertValue(vehicle,VehicleDto.class)).toList();
    }


}
