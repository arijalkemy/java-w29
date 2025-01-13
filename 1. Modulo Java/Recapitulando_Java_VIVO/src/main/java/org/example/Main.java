package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1);
        garaje.agregarVehiculoGaraje(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.agregarVehiculoGaraje(new Vehiculo("Focus", "Ford", 1200));
        garaje.agregarVehiculoGaraje(new Vehiculo("Explorer", "Ford", 2500));
        garaje.agregarVehiculoGaraje(new Vehiculo("Uno", "Fiat", 500));
        garaje.agregarVehiculoGaraje(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.agregarVehiculoGaraje(new Vehiculo("Torino", "Fiat", 1250));
        garaje.agregarVehiculoGaraje(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.agregarVehiculoGaraje(new Vehiculo("Corola", "Toyota", 1200));
        garaje.agregarVehiculoGaraje(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.agregarVehiculoGaraje(new Vehiculo("Logan", "Renault", 950));


        List<Vehiculo> vehiculos = garaje.getGaraje();
        vehiculos.sort((v1, v2) -> Integer.compare(v1.getCosto(), v2.getCosto()));
        System.out.println("Vehiculos ordenados por costo:");
        vehiculos.forEach(System.out::println);
        System.out.println("                              ");
        System.out.println("Vehiculos ordenados por marca y por costo:");
        vehiculos.sort(Comparator.comparing(Vehiculo::getMarca)
        .thenComparing(Vehiculo::getCosto));
        vehiculos.forEach(System.out::println);
        System.out.println("                              ");
        System.out.println("Vehiculos con precio menor a 1000:");
        List<Vehiculo> menorMonto = garaje.getGaraje().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .collect(Collectors.toList());
        menorMonto.forEach(System.out::println);
        System.out.println("                              ");
        System.out.println("Vehiculos con precio mayor o igual a 1000:");
        List<Vehiculo> mayorMonto = garaje.getGaraje().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .collect(Collectors.toList());
        mayorMonto.forEach(System.out::println);
        System.out.println("                              ");
        System.out.println("Promedio precios de todos los vehiculos:");
        int promedio = (int) garaje.getGaraje().stream()
                .mapToInt(Vehiculo::getCosto)
                .average().orElse(0);
        System.out.println(promedio);
    }
}