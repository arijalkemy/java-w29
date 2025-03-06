package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class UtilVehicle {

    public static Vehicle getVehicle() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(4L);
        vehicle.setBrand("Toyota");
        vehicle.setModel("4Runner");
        vehicle.setRegistration("496");
        vehicle.setColor("Green");
        vehicle.setYear(1994);
        vehicle.setMax_speed("127");
        vehicle.setPassengers(1);
        vehicle.setFuel_type("gas");
        vehicle.setTransmission("automatic");
        vehicle.setHeight(251.59);
        vehicle.setWidth(121.06);
        vehicle.setWeight(65.19);
        return vehicle;
    }

    public static VehicleDto toDto(Vehicle vehicle) {
        if (vehicle == null) {
            return null;
        }
        VehicleDto dto = new VehicleDto();
        dto.setId(vehicle.getId());
        dto.setBrand(vehicle.getBrand());
        dto.setModel(vehicle.getModel());
        dto.setRegistration(vehicle.getRegistration());
        dto.setColor(vehicle.getColor());
        dto.setYear(vehicle.getYear());
        dto.setMax_speed(vehicle.getMax_speed());
        dto.setPassengers(vehicle.getPassengers());
        dto.setFuel_type(vehicle.getFuel_type());
        dto.setTransmission(vehicle.getTransmission());
        dto.setHeight(vehicle.getHeight());
        dto.setWidth(vehicle.getWidth());
        dto.setWeight(vehicle.getWeight());
        return dto;
    }
}
