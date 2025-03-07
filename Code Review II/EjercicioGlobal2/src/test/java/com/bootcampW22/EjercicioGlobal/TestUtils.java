package com.bootcampW22.EjercicioGlobal;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.bootcampW22.EjercicioGlobal.utils.VehicleBuilder;
import com.github.javafaker.Faker;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class TestUtils {

    public static Vehicle createRandomVehicle() {
        return new VehicleBuilder().build();
    }

    public static Vehicle createRandomVehicleWithYearAndColor(int year, String color) {
        return new VehicleBuilder()
                .setYear(year)
                .setColor(color)
                .build();
    }

    public static Vehicle createRandomVehicleWithBrandAndRangeOfYear(String brand, int start_year, int end_year) {
        int year = start_year + new Random().nextInt(end_year - start_year + 1);
        return new VehicleBuilder()
                .setBrand(brand)
                .setYear(year)
                .build();
    }

    public static Vehicle createRandomVehicleWithRangeOfWeight(double weight_min, double weight_max) {
        double weight = weight_min + new Random().nextDouble(weight_max - weight_min + 1);
        return new VehicleBuilder()
                .setWeight(weight)
                .build();
    }

    public static Vehicle createRandomVehicleWithBrandAndMaxSpeed(String brand, String max_speed) {
        return new VehicleBuilder()
                .setBrand(brand)
                .setMaxSpeed(max_speed)
                .build();
    }

    public static Vehicle createRandomVehicleWithBrandAndPassengers(String brand, int passengers) {
        return new VehicleBuilder()
                .setBrand(brand)
                .setPassengers(passengers)
                .build();
    }

    public static VehicleDto convertVehicleToDto(Vehicle vehicle) {
        VehicleDto vehicleDto = new VehicleDto();
        vehicleDto.setId(vehicle.getId());
        vehicleDto.setBrand(vehicle.getBrand());
        vehicleDto.setModel(vehicle.getModel());
        vehicleDto.setRegistration(vehicle.getRegistration());
        vehicleDto.setColor(vehicle.getColor());
        vehicleDto.setYear(vehicle.getYear());
        vehicleDto.setMax_speed(vehicle.getMax_speed());
        vehicleDto.setPassengers(vehicle.getPassengers());
        vehicleDto.setFuel_type(vehicle.getFuel_type());
        vehicleDto.setTransmission(vehicle.getTransmission());
        vehicleDto.setHeight(vehicle.getHeight());
        vehicleDto.setWidth(vehicle.getWidth());
        vehicleDto.setWeight(vehicle.getWeight());
        return vehicleDto;
    }

    public static List<Vehicle> createListRandomVehicles(int size) {
        return IntStream.range(0, size)
                .mapToObj(i -> createRandomVehicle())
                .collect(Collectors.toList());
    }

    public static List<Vehicle> createListRandomVehiclesWithYearAndColor(int size, Integer year, String color) {
        return IntStream.range(0, size)
                .mapToObj(i -> createRandomVehicleWithYearAndColor(year, color))
                .collect(Collectors.toList());
    }

    public static List<Vehicle> createListRandomVehiclesWithBrandAndRangeOfYear(int size, String brand, int start_year, int end_year) {
        return IntStream.range(0, size)
                .mapToObj(i -> createRandomVehicleWithBrandAndRangeOfYear(brand, start_year, end_year))
                .collect(Collectors.toList());
    }

    public static List<Vehicle> createListRandomVehiclesWithRangeOfWeight(int size, double weight_min, double weight_max) {
        return IntStream.range(0, size)
                .mapToObj(i -> createRandomVehicleWithRangeOfWeight(weight_min, weight_max))
                .collect(Collectors.toList());
    }
}