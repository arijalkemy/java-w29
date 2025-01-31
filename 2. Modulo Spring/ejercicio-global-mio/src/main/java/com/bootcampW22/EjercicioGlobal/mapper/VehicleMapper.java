package com.bootcampW22.EjercicioGlobal.mapper;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDTO;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class VehicleMapper {
    public static Vehicle dtoToVehicle (VehicleDTO vehicleDto) {
        Vehicle vehicle = new Vehicle();

        vehicle.setId(vehicleDto.getId());
        vehicle.setBrand(vehicleDto.getBrand());
        vehicle.setModel(vehicleDto.getModel());
        vehicle.setRegistration(vehicleDto.getRegistration());
        vehicle.setYear(vehicleDto.getYear());
        vehicle.setColor(vehicleDto.getColor());
        vehicle.setMax_speed(vehicleDto.getMax_speed());
        vehicle.setFuel_type(vehicleDto.getFuel_type());
        vehicle.setTransmission(vehicleDto.getTransmission());
        vehicle.setPassengers(vehicleDto.getPassengers());
        vehicle.setHeight(vehicleDto.getHeight());
        vehicle.setWidth(vehicleDto.getWidth());
        vehicle.setWeight(vehicleDto.getWeight());

        return vehicle;
    }

    public static VehicleDTO vehicleToDto (Vehicle vehicle) {
        VehicleDTO vehicleDto = new VehicleDTO();

        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setRegistration(vehicle.getRegistration());
        vehicleDto.setYear(vehicle.getYear());
        vehicleDto.setColor(vehicle.getColor());
        vehicleDto.setMax_speed(vehicle.getMax_speed());
        vehicleDto.setFuel_type(vehicle.getFuel_type());
        vehicleDto.setTransmission(vehicle.getTransmission());
        vehicleDto.setPassengers(vehicle.getPassengers());
        vehicleDto.setHeight(vehicle.getHeight());
        vehicleDto.setWidth(vehicle.getWidth());
        vehicleDto.setWeight(vehicle.getWeight());

        return vehicleDto;
    }
}
