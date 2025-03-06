package com.bootcampW22.EjercicioGlobal.util;

import com.bootcampW22.EjercicioGlobal.dto.VehicleDto;
import com.bootcampW22.EjercicioGlobal.entity.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class VehicleUtil {

    public static List<Vehicle> getVehiclesListYearAndColor() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(1L, "Buick", "ModelX", "ABC123", "Green", 2005, "150", 4, "gas", "manual", 200.5, 100.2, 1500.0));
        vehicleList.add(new Vehicle(2L, "Mitsubishi", "ModelY", "XYZ789", "Green", 2005, "160", 5, "diesel", "automatic", 210.0, 105.5, 1600.0));
        return vehicleList;
    }

    public static List<Vehicle> getVehiclesListYearAndBrand() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(3L, "Toyota", "Corolla", "REG001", "Blue", 2005, "170", 5, "gas", "automatic", 220.3, 110.7, 1400.0));
        vehicleList.add(new Vehicle(4L, "Toyota", "Camry", "REG002", "Red", 2002, "180", 5, "hybrid", "automatic", 225.0, 112.0, 1450.0));
        vehicleList.add(new Vehicle(5L, "Toyota", "Yaris", "REG003", "White", 2000, "160", 4, "gas", "manual", 210.8, 108.3, 1300.0));
        return vehicleList;
    }

    public static List<Vehicle> getVehiclesListMaxSpeedAndBrand() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(6L, "Toyota", "Supra", "REG004", "Yellow", 2010, "100", 2, "gas", "manual", 190.5, 95.3, 1200.0));
        vehicleList.add(new Vehicle(7L, "Toyota", "Celica", "REG005", "Black", 2008, "200", 4, "gas", "automatic", 200.0, 100.0, 1250.0));
        vehicleList.add(new Vehicle(8L, "Toyota", "Corolla", "REG006", "Silver", 2007, "200", 5, "hybrid", "automatic", 210.3, 105.7, 1350.0));
        vehicleList.add(new Vehicle(9L, "Toyota", "Prius", "REG007", "Green", 2012, "100", 5, "electric", "automatic", 215.2, 107.1, 1400.0));
        return vehicleList;
    }

    public static List<Vehicle> getVehiclesListPassengersAndBrand() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(10L, "Toyota", "Highlander", "REG008", "White", 2015, "180", 4, "gas", "automatic", 230.0, 115.0, 1600.0));
        vehicleList.add(new Vehicle(11L, "Toyota", "RAV4", "REG009", "Blue", 2017, "175", 2, "hybrid", "automatic", 225.3, 112.5, 1550.0));
        vehicleList.add(new Vehicle(12L, "Toyota", "Sienna", "REG010", "Gray", 2020, "190", 4, "gas", "automatic", 235.7, 118.2, 1700.0));
        vehicleList.add(new Vehicle(13L, "Toyota", "Land Cruiser", "REG011", "Black", 2022, "200", 2, "diesel", "automatic", 240.5, 120.3, 1800.0));
        return vehicleList;
    }

    public static List<Vehicle> getVehiclesListWeight() {
        List<Vehicle> vehicleList = new ArrayList<>();
        vehicleList.add(new Vehicle(14L, "Toyota", "Focus", "REG012", "Blue", 2018, "160", 5, "gas", "automatic", 220.0, 110.0, 1600.0));
        vehicleList.add(new Vehicle(15L, "Mitsubishi", "Civic", "REG013", "Red", 2019, "170", 5, "hybrid", "automatic", 225.0, 112.0, 1550.0));
        vehicleList.add(new Vehicle(16L, "Toyota", "Malibu", "REG014", "Black", 2021, "180", 5, "gas", "manual", 230.0, 115.0, 1700.0));
        vehicleList.add(new Vehicle(17L, "Mitsubishi", "Altima", "REG015", "White", 2022, "190", 5, "diesel", "automatic", 235.0, 118.0, 1800.0));
        return vehicleList;
    }

    public static VehicleDto entityToDTO(Vehicle vehicle) {
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
