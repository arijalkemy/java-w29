package org.example;

import org.example.model.Garage;
import org.example.model.Vehicle;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Vehicle vehiculo1 = new Vehicle("Fiesta", "Ford", 1000);
        Vehicle vehiculo2 = new Vehicle("Focus", "Ford", 1200);
        Vehicle vehiculo3 = new Vehicle("Explorer", "Ford", 2500);
        Vehicle vehiculo4 = new Vehicle("Uno", "Fiat", 500);
        Vehicle vehiculo5 = new Vehicle("Cronos", "Fiat", 1000);
        Vehicle vehiculo6 = new Vehicle("Torino", "Fiat", 1250);
        Vehicle vehiculo7 = new Vehicle("Aveo", "Chevrolet", 1250);
        Vehicle vehiculo8 = new Vehicle("Spin", "Chevrolet", 2500);
        Vehicle vehiculo9 = new Vehicle("Corola", "Toyota", 1200);
        Vehicle vehiculo10 = new Vehicle("Fortuner", "Toyota", 3000);
        Vehicle vehiculo11 = new Vehicle("Logan", "Renault", 950);

        List<Vehicle> vehicles = new ArrayList<>();

        vehicles.add(vehiculo1);
        vehicles.add(vehiculo2);
        vehicles.add(vehiculo3);
        vehicles.add(vehiculo4);
        vehicles.add(vehiculo5);
        vehicles.add(vehiculo6);
        vehicles.add(vehiculo7);
        vehicles.add(vehiculo8);
        vehicles.add(vehiculo9);
        vehicles.add(vehiculo10);
        vehicles.add(vehiculo11);

        Garage garage = new Garage(1,vehicles);

        System.out.println("Vehículos ordenados por precio (menor a mayor):");
        garage.getGarage().stream()
                .sorted(Comparator.comparingDouble(Vehicle::getCosto))
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        System.out.println("Vehículos ordenados por precio (mayor a menor):");
        garage.getGarage().stream()
                .sorted(Comparator.comparingDouble(Vehicle::getCosto).reversed())
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        System.out.println("Vehículos ordenados por marca y luego por precio:");
        garage.getGarage().stream()
                .sorted(Comparator.comparing(Vehicle::getMarca)
                        .thenComparingDouble(Vehicle::getCosto))
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        System.out.println("Vehículos con precio no mayor a 1000:");
        garage.getGarage().stream()
                .filter(v -> v.getCosto() < 1000)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        System.out.println("Vehículos con precio mayor a 1000:");
        garage.getGarage().stream()
                .filter(v -> v.getCosto() >= 1000)
                .forEach(System.out::println);

        System.out.println("-----------------------------");

        System.out.println("Promedio de precios");
        double avg = garage.getGarage().stream()
                .mapToDouble(Vehicle::getCosto)
                .average()
                .getAsDouble();

        System.out.println("El promedio de los costos es: " + avg);
    }
}