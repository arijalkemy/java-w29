package com.vehiculos.garage;

import java.util.List;

public class GarageApplication {
    
    public static void main(String[] args) {
        List<Vehiculo> listaVehiculos = List.of(
                new Vehiculo("Fiesta", "Ford", 1000),
                new Vehiculo("Focus", "Ford", 1200),
                new Vehiculo("Explorer", "Ford", 2500),
                new Vehiculo("Uno", "Fiat", 500),
                new Vehiculo("Cronos", "Fiat", 1000),
                new Vehiculo("Torino", "Fiat", 1250),
                new Vehiculo("Aveo", "Chevrolet", 1250),
                new Vehiculo("Spin", "Chevrolet", 2500),
                new Vehiculo("Corola", "Toyota", 1200),
                new Vehiculo("Fortuner", "Toyota", 3000),
                new Vehiculo("Logan", "Renault", 950)
        );

        //Ejercicio 3
        List<Vehiculo> vehiculosOrdenadosMenorAMayor = listaVehiculos.stream()
                .sorted((vehiculo1, vehiculo2) -> Integer.compare(vehiculo1.getCosto(), vehiculo2.getCosto())
                ).toList();

        vehiculosOrdenadosMenorAMayor.forEach(vehiculo -> System.out.println(vehiculo.getCosto()));

        //Ejercicio 4
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPorPrecio = listaVehiculos.stream()
                .sorted((vehiculo1, vehiculo2) -> Integer.compare(vehiculo1.getCosto(), vehiculo2.getCosto())
                ).sorted((v1, v2) -> v1.getMarca().compareToIgnoreCase(v2.getMarca()))
                .toList();


        vehiculosOrdenadosPorMarcaYPorPrecio.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        //Ejercicio 5

        //Parte 1
        List<Vehiculo> vehiculosConPrecioNoMayorA1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .toList();

        vehiculosConPrecioNoMayorA1000.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        //Parte 2

        List<Vehiculo> vehiculosConPreciosMayorOIgualA1000 = listaVehiculos.stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .toList();

        vehiculosConPreciosMayorOIgualA1000.forEach(vehiculo -> System.out.println(vehiculo.getMarca() + " " + vehiculo.getCosto()));

        double promedio = (listaVehiculos.stream()
                .map(vehiculo -> vehiculo.getCosto())
        ).toList().stream()
                .mapToInt(Integer::intValue)
                .average()
                .orElse(0.0);

        System.out.println(promedio);
    }
}
