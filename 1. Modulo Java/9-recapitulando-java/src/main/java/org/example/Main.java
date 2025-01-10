package org.example;

import org.example.model.Garaje;
import org.example.model.Vehiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        // ejercicio 2
        List<Vehiculo> vehiculos = new ArrayList<>(){{
            add(new Vehiculo("Ford", "Fiesta", 1000));
            add(new Vehiculo("Ford", "Focus", 1200));
            add(new Vehiculo("Ford", "Explorer", 2500));
            add(new Vehiculo("Fiat", "Uno", 500));
            add(new Vehiculo("Fiat", "Cronos", 1000));
            add(new Vehiculo("Fiat", "Torino", 1250));
            add(new Vehiculo("Chevrolet", "Aveo", 1250));
            add(new Vehiculo("Chevrolet", "Spin", 2500));
            add(new Vehiculo("Toyota", "Corola", 1200));
            add(new Vehiculo("Toyota", "Fortuner", 3000));
            add(new Vehiculo("Renault", "Logan", 950));
        }};

        Garaje garage = new Garaje(1, vehiculos);

        // ejercicio 3
        vehiculos.sort((v1, v2) -> Integer.compare(v1.getCosto(), v2.getCosto()));
        System.out.println("Vehiculos ordenados por precio: menor a mayor");
        vehiculos.forEach(System.out::println);

        // ejercicio 4
        vehiculos.sort((v1, v2) -> {
            int comparacionString = v1.getMarca().compareTo(v2.getMarca()); // devuelve -1, 0, 1; 0 es cuando son iguales
            if(comparacionString == 0){
                return Integer.compare(v1.getCosto(), v2.getCosto());
            }
            return comparacionString;
        });
        System.out.println("\nVehiculos ordenados por marca y luego por precio");
        vehiculos.forEach(System.out::println);

        // ejercicio 5
        List<Vehiculo> precioNoMayor1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .collect(Collectors.toList());
        System.out.println("\nVehiculos con precio menor a 1000");
        precioNoMayor1000.forEach(System.out::println);

        List<Vehiculo> precioMayor1000 = vehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        System.out.println("\nVehiculos con precio mayor a 1000");
        precioMayor1000.forEach(System.out::println);

        Double promedioPrecios = vehiculos.stream()
                .map(v -> v.getCosto())
                .reduce(0, Integer::sum) / (double) vehiculos.size();
        System.out.println("\nEl promedio de precios es: " + promedioPrecios);
    }
}