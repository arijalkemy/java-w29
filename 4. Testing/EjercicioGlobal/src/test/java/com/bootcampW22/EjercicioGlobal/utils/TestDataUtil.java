package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.fasterxml.jackson.core.type.ResolvedType;

import java.util.ArrayList;
import java.util.List;

public class TestDataUtil {

    public static List<Vehicle> getTestVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180", 5, "Gasoline", "Automatic", 1.4, 1.8, 1300.0));
        vehicles.add(new Vehicle(2L, "Ford", "Focus", "XYZ789", "Blue", 2019, "200", 4, "Diesel", "Manual", 1.5, 1.9, 1400.0));
        vehicles.add(new Vehicle(3L, "Toyota", "Yaris", "JKL456", "Black", 2018, "160", 5, "Hybrid", "Automatic", 1.3, 1.7, 1200.0));
        vehicles.add(new Vehicle(4L, "Chevrolet", "Onix", "QWE789", "White", 2021, "190", 5, "Gasoline", "Manual", 1.6, 1.8, 1250.0));
        vehicles.add(new Vehicle(5L, "Volkswagen", "Golf", "MNO321", "Gray", 2017, "220", 5, "Gasoline", "Automatic", 1.4, 1.8, 1350.0));

        return vehicles;
    }
    public static List<Vehicle> getToyotaTestVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180", 5, "Gasoline", "Automatic", 1.4, 1.8, 1300.0));
        vehicles.add(new Vehicle(3L, "Toyota", "Yaris", "JKL456", "Black", 2018, "160", 5, "Hybrid", "Automatic", 1.3, 1.7, 1200.0));
        return vehicles;
    }


    public static Vehicle getVehicleRedAnd2020() {
        return new Vehicle(1L, "Toyota", "Corolla", "ABC123", "Red", 2020, "180", 5, "Gasoline", "Automatic", 1.4, 1.8, 1300.0);
    }


    public static Vehicle getVehiclePontiac1987() {
        return Vehicle.builder()
                .brand("Pontiac")
                .year(1987)
                .build();
    }


    public static List<Vehicle> getVehiclesByWeightRange() {
            return List.of(
                    Vehicle.builder()
                            .brand("Toyota")
                            .weight(1400)
                            .build(),
                    Vehicle.builder()
                            .id(2L)
                            .brand("Ford")
                            .weight(1600.0)
                            .build());

    }
}
