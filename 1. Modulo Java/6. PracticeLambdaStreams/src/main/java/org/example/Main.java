package org.example;

import org.example.model.Garage;
import org.example.model.Vehicle;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Vehicle("Ford", "Fiesta", 1000));
        vehicles.add(new Vehicle("Ford", "Focus", 1200));
        vehicles.add(new Vehicle("Ford", "Explorer", 2500));
        vehicles.add(new Vehicle("Fiat", "Uno", 500));
        vehicles.add(new Vehicle("Fiat", "Cronos", 1000));
        vehicles.add(new Vehicle("Fiat", "Torino", 1250));
        vehicles.add(new Vehicle("Chevrolet", "Aveo", 1250));
        vehicles.add(new Vehicle("Chevrolet", "Spin", 2500));
        vehicles.add(new Vehicle("Toyota", "Corola", 1200));
        vehicles.add(new Vehicle("Toyota", "Fortuner", 3000));
        vehicles.add(new Vehicle("Renault", "Logan", 950));

        Garage garage = new Garage(1, vehicles);

        System.out.println("\n Ordenada por precio");
        garage.getVehicleList().stream().sorted(Comparator.comparingDouble(Vehicle::getPrice)).forEach(System.out::println);

        System.out.println("\n Ordenada por marca y precio");
        garage.getVehicleList().stream().sorted(Comparator.comparingDouble(Vehicle::getPrice)).sorted(Comparator.comparing(Vehicle::getBrand)).forEach(System.out::println);

        List<Vehicle> vehiclesLess1000 = garage.getVehicleList().stream().filter(vehicle -> vehicle.getPrice() < 1000).toList();
        List<Vehicle> vehiclesGreater1000 = garage.getVehicleList().stream().filter(vehicle -> vehicle.getPrice() >= 1000).toList();

        System.out.println("\n Lista vehiculos precio no mayor a 1000");
        System.out.println(vehiclesLess1000);
        System.out.println("\n Lista vehiculos precio mayores o igual a 1000");
        System.out.println(vehiclesGreater1000);

        System.out.println("\n Promedio total de vehiculos");
        double average = garage.getVehicleList().stream().mapToDouble(Vehicle::getPrice).average().getAsDouble();
        System.out.printf("%,.2f%n", average);
    }
}