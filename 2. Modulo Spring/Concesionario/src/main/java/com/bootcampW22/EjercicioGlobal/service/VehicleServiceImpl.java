package com.bootcampW22.EjercicioGlobal.service;

import com.bootcampW22.EjercicioGlobal.dto.AverageSpeedDto;
import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.exception.BadRequest;
import com.bootcampW22.EjercicioGlobal.exception.NotFoundException;
import com.bootcampW22.EjercicioGlobal.repository.IVehicleRepository;
import com.bootcampW22.EjercicioGlobal.repository.VehicleRepositoryImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
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

    @Override
    public void addVehicle(Vehicle vehicle) {
        ObjectMapper mapper = new ObjectMapper();
        if(vehicleRepository.findOnlyById(vehicle.getId())){
            throw new NotFoundException("El vehiculo ya existe");
        }
        Vehicle newVehicle = mapper.convertValue(vehicle,Vehicle.class);
        vehicleRepository.save(newVehicle);
    }

    @Override
    public List<VehicleDto> searchByColorAndYear(String color, int year) {
        if(vehicleRepository.searchByColorAndYear(color,year).isEmpty()){
            throw new NotFoundException("No hay vehiculos con ese color y ese año.");
        }
        return vehicleRepository.searchByColorAndYear(color,year);
    }

    @Override
    public List<VehicleDto> searchByBrandAndDates(String brand, int startYear, int endYear) {
        if (vehicleRepository.searchByBrandAndDates(brand,startYear,endYear).isEmpty()){
            throw new NotFoundException("No hay vehiculos con esa marca entre las fechas indicadas.");
        }
        return vehicleRepository.searchByBrandAndDates(brand,startYear,endYear);
    }

    @Override
    public AverageSpeedDto calculateAverageSpeedByBrand(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.getByBrand(brand);
        if(vehicleList.isEmpty()){
            throw new NotFoundException("No hay vehiculos con esa marca.");
        }
        Double averageSpeed = vehicleList.stream()
                .mapToDouble(vehicle ->
                    Double.parseDouble(vehicle.getMax_speed())
                )
                .average()
                .orElse(0.0);
        return new AverageSpeedDto(brand,averageSpeed);
    }

    @Override
    public void addListOfVehicles(List<VehicleDto> vehicleDtos) {
        ObjectMapper mapper = new ObjectMapper();
        if(vehicleDtos.isEmpty()){
            throw new BadRequest("No hay vehiculos a cargar.");
        }
        for (VehicleDto vehicleDto : vehicleDtos) {
            Vehicle vehicle = mapper.convertValue(vehicleDto,Vehicle.class);
            vehicleRepository.save(vehicle);
        }
    }

    @Override
    public void updateVehicleSpeed(Long id, String speed) {
        if(!vehicleRepository.findOnlyById(id)){
            throw new NotFoundException("El vehiculo no existe.");
        }
        vehicleRepository.updateVehicleSpeed(id,speed);
    }

    @Override
    public List<VehicleDto> searchByFuelType(String type) {
        if(vehicleRepository.searchByFuelType(type).isEmpty()){
            throw new NotFoundException("No hay vehiculos con ese tipo de combustible.");
        }
        return vehicleRepository.searchByFuelType(type);
    }

    @Override
    public void removeVehicle(Long id) {
        if(!vehicleRepository.findOnlyById(id)){
            throw new NotFoundException("El vehiculo a eliminar no existe.");
        }
        vehicleRepository.removeVehicle(id);
    }

    @Override
    public List<VehicleDto> searchByTransmission(String type) {
        if(vehicleRepository.searchByTransmissionType(type).isEmpty()){
            throw new NotFoundException("No hay vehiculos con ese tipo de transmisión.");
        }
        return vehicleRepository.searchByTransmissionType(type);
    }

    @Override
    public void updateVehicleFuelType(Long id, String fuel) {
        if(!vehicleRepository.findOnlyById(id)){
            throw new NotFoundException("El vehiculo con ese id no existe.");
        }
        vehicleRepository.updateVehicleFuel(id,fuel);
    }

    @Override
    public Double searchAverageCapacity(String brand) {
        List<Vehicle> vehicleList = vehicleRepository.getByBrand(brand);
        if(vehicleRepository.getByBrand(brand).isEmpty()){
            throw new NotFoundException("No hay vehiculos con esa marca.");
        }
        return vehicleList.stream()
                .mapToInt(Vehicle::getPassengers).average().orElse(0);

    }

    @Override
    public List<VehicleDto> searchVehiclesByDimensions(String lengthRange, String widthRange) {
        String[] lengths = lengthRange.split("-");
        String[] widths = widthRange.split("-");
        Double minLengths = Double.parseDouble(lengths[0]);
        Double maxLengths = Double.parseDouble(lengths[1]);
        Double minWidth = Double.parseDouble(widths[0]);
        Double maxWidth = Double.parseDouble(widths[1]);
        if(vehicleRepository.searchByDimensions(minLengths,maxLengths,minWidth,maxWidth).isEmpty()){
            throw new NotFoundException("No hay vehiculos con esas dimensiones.");
        }
        return vehicleRepository.searchByDimensions(minLengths,maxLengths,minWidth,maxWidth);
    }

    @Override
    public List<VehicleDto> searchVehicleByWeight(Double min, Double max) {
        if(vehicleRepository.searchByWeight(min,max).isEmpty()){
            throw new NotFoundException("No hay vehiculos con ese peso.");
        }
        return vehicleRepository.searchByWeight(min,max);
    }
}
