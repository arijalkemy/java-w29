package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

public class UtilVehicle {

    public static Vehicle createVehicle(Long id, String brand, String model, String registration, String color,
                                        int year, String maxSpeed, int passengers, String fuelType,
                                        String transmission, double height, double width, double weight) {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(id);
        vehicle.setBrand(brand);
        vehicle.setModel(model);
        vehicle.setRegistration(registration);
        vehicle.setColor(color);
        vehicle.setYear(year);
        vehicle.setMax_speed(maxSpeed);
        vehicle.setPassengers(passengers);
        vehicle.setFuel_type(fuelType);
        vehicle.setTransmission(transmission);
        vehicle.setHeight(height);
        vehicle.setWidth(width);
        vehicle.setWeight(weight);
        return vehicle;
    }

    public static Vehicle createDefaultVehicle() {
        return createVehicle(
                1L,
                "Toyota",
                "Corolla",
                "ABC1234",
                "Green",
                2005,
                "120",
                5,
                "Gasoline",
                "Automatic",
                1.5,
                1.8,
                1500.0
        );
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
