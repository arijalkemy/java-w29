package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageVehiclesDto;
import com.bootcampW22.EjercicioGlobal.dto.ExceptionDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.Conflict;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

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

    //[US-0001]
    @Override
    public ResponseEntity<ExceptionDto> createVehiculo(Vehicle vehicle) {
        if (vehicleRepository.findById(vehicle.getId())){
            throw new Conflict("El vehichulo ya existe");
        }
        vehicleRepository.addVehicle(vehicle);
        return new ResponseEntity<ExceptionDto>(new ExceptionDto("Se agrego exitosamente"), HttpStatus.CREATED);
    }

    //[US-0002]
    @Override
    public List<VehicleDto> searchVehiclesByColorByYear(String color, int year) {
        ObjectMapper mapper = new ObjectMapper();
        if (vehicleRepository.getVehiclesByColorYear(color,year).isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }

        return vehicleRepository.getVehiclesByColorYear(color,year).stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .collect(Collectors.toList());
    }

    //[US-0003]
    @Override
    public List<VehicleDto> searchVehiclesByBrandByBeetweenYears(String brand, int startYear, int endYear) {
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.getVehiclesByCBrandByBeetweenYears(brand,startYear,endYear);
        if (vehicles.isEmpty()){
            throw new NotFoundException("No se encontraron vehículos con esos criterios");
        }

        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .collect(Collectors.toList());
    }

    //[US-0004]
    @Override
    public AverageVehiclesDto calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicles = vehicleRepository.findVehicleByBrand(brand);
        if (vehicles.isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos de esa marca.");
        }
        Double averageSpeed = vehicles.stream()
                .mapToDouble(vehicle -> Double.parseDouble(vehicle.getMax_speed()))
                .average()
                .orElse(0.0);
        return new AverageVehiclesDto(brand,averageSpeed);
    }

    //[US-0005]
    @Override
    public ResponseEntity<ExceptionDto> createBatchVehicles(List<Vehicle> vehicles) {
            if (vehicles.isEmpty()){
                throw new Conflict("No se ingresaron elementos");
            }
        vehicles.stream()
                    .forEach(vehicle -> {
                        if (vehicleRepository.findById(vehicle.getId())){
                            throw new Conflict("Algún vehículo tiene un identificador ya existente.");
                        }
                        vehicleRepository.addVehicle(vehicle);
                    });

            return new ResponseEntity<ExceptionDto>(new ExceptionDto("Se agregaron exitosamente"), HttpStatus.CREATED);
        }

    //[US-0006]
    @Override
    public ResponseEntity<ExceptionDto> updateMaxSpeed(Long id, String updateSpeed) {
        if (!vehicleRepository.findById(id)) {
            throw new NotFoundException("No se encontró el vehículo");
        }
        vehicleRepository.updateMaxSpeedVehicle(id,updateSpeed);
        return new ResponseEntity<ExceptionDto>(new ExceptionDto("Se agregaron exitosamente"), HttpStatus.OK);
    }

    //[US-0007]
    @Override
    public List<VehicleDto> searchByFuelType(String type) {
        if(vehicleRepository.searchByFuelType(type).isEmpty()){
            throw new NotFoundException("No hay vehiculos con ese tipo de combustible.");
        }
        return vehicleRepository.searchByFuelType(type);
    }

    //[US-0012]
    @Override
    public List<VehicleDto> searchVehiclesByDimensions(String lengthRange, String widthRange) {
        String[] lengths = lengthRange.split("-");
        String[] widths = widthRange.split("-");
        Double minlength = Double.parseDouble(lengths[0]);
        Double maxlength = Double.parseDouble(lengths[1]);
        Double minwidth = Double.parseDouble(widths[0]);
        Double maxwidth = Double.parseDouble(widths[1]);
        ObjectMapper mapper = new ObjectMapper();
        List<Vehicle> vehicles = vehicleRepository.findByDimensions(minlength, maxlength, minwidth, maxwidth);
        if (vehicleRepository.findByDimensions(minlength, maxlength, minwidth, maxwidth).isEmpty()) {
            throw new NotFoundException("No se encontraron vehículos con esas dimensiones.");
        }
        return vehicles.stream()
                .map(vehicle -> mapper.convertValue(vehicle,VehicleDto.class))
                .collect(Collectors.toList());
    }


}
