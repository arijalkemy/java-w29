package org.example;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje("G001");


        garaje.agregarVehiculo(new Vehiculo("Fiesta", "Ford", 1000));
        garaje.agregarVehiculo(new Vehiculo("Focus", "Ford", 1200));
        garaje.agregarVehiculo(new Vehiculo("Explorer", "Ford", 2500));
        garaje.agregarVehiculo(new Vehiculo("Uno", "Fiat", 500));
        garaje.agregarVehiculo(new Vehiculo("Cronos", "Fiat", 1000));
        garaje.agregarVehiculo(new Vehiculo("Torino", "Fiat", 1250));
        garaje.agregarVehiculo(new Vehiculo("Aveo", "Chevrolet", 1250));
        garaje.agregarVehiculo(new Vehiculo("Spin", "Chevrolet", 2500));
        garaje.agregarVehiculo(new Vehiculo("Corola", "Toyota", 1200));
        garaje.agregarVehiculo(new Vehiculo("Fortuner", "Toyota", 3000));
        garaje.agregarVehiculo(new Vehiculo("Logan", "Renault", 950));


        System.out.println("Vehículos en el garaje:");
        for (Vehiculo vehiculo : garaje.getVehiculos()) {
            System.out.println(vehiculo);
        }

        List<Vehiculo> vehiculosOrdenadosPorPrecio = new ArrayList<>(garaje.getVehiculos());
        vehiculosOrdenadosPorPrecio.sort(Comparator.comparingDouble(Vehiculo::getCosto));

        //Ordenarprecio
        List<Vehiculo> vehiculosOrdenadosPorMarcaYPrecio = new ArrayList<>(garaje.getVehiculos());
        vehiculosOrdenadosPorMarcaYPrecio.sort(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto));
        System.out.println("\nVehículos ordenados por precio (menor a mayor):");
        for (Vehiculo vehiculo : vehiculosOrdenadosPorPrecio) {
            System.out.println(vehiculo);
        }


        //Ordenar marca
        System.out.println("\nVehículos ordenados por marca y precio:");
        for (Vehiculo vehiculo : vehiculosOrdenadosPorMarcaYPrecio) {
            System.out.println(vehiculo);
        }

        // Filtrar vehículos con precio no mayor a 1000
        List<Vehiculo> vehiculosMenorOIgual1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() <= 1000)
                .collect(Collectors.toList());

        System.out.println("\nVehículos con precio no mayor a 1000:");
        for (Vehiculo vehiculo : vehiculosMenorOIgual1000) {
            System.out.println(vehiculo);
        }

        // Filtrar vehículos con precio mayor o igual a 1000
        List<Vehiculo> vehiculosMayor1000 = garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() > 1000)
                .collect(Collectors.toList());

        System.out.println("\nVehículos con precio mayor a 1000:");
        for (Vehiculo vehiculo : vehiculosMayor1000) {
            System.out.println(vehiculo);
        }

        // Calcular promedio de precios
        double promedioPrecio = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0.0);

        System.out.println("\nPromedio total de precios de toda la lista de vehículos: " + promedioPrecio);
    }
}