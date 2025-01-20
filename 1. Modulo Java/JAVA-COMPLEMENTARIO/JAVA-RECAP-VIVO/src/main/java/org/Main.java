package org;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        Garaje g1 = new Garaje(1, new ArrayList<>(List.of(
                new Vehiculo("Ford", "Fiesta", 1000),
                new Vehiculo("Ford", "Focus", 1200),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        )));

        System.out.println(g1.toString());


        // Ordenar por precio
        g1.getListadoVehiculos().sort(Comparator.comparingDouble(Vehiculo::getCosto));
        System.out.println("Vehiculos sorted by costo");
        g1.getListadoVehiculos().forEach(System.out::println);


        // Ordenar por marca y luego por precio
        g1.getListadoVehiculos().sort(Comparator.comparing(Vehiculo::getMarca)
                .thenComparingDouble(Vehiculo::getCosto));
        System.out.println("\nVehículos ordenados por marca y luego por precio:");
        g1.getListadoVehiculos().forEach(System.out::println);


        // Lista de vehículos con precio no mayor a 1000
        List<Vehiculo> precioMenorA1000 = g1.getListadoVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .toList();
        System.out.println("\nVehículos con precio no mayor a $1000:");
        precioMenorA1000.forEach(System.out::println);


        // Lista de vehículos con precio mayor o igual a 1000
        List<Vehiculo> precioMayorOIgualA1000 = g1.getListadoVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .toList();
        System.out.println("\nVehículos con precio mayor o igual a $1000:");
        precioMayorOIgualA1000.forEach(System.out::println);




        // Promedio de precios de todos los vehículos
        double promedioPrecios = g1.getListadoVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
        System.out.println("\nPromedio total de precios de los vehículos: $" + promedioPrecios);
    }
}

