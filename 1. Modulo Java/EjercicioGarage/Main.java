package com.meli;

import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Vehiculo> vehiculos = List.of(
                new Vehiculo("Ford", "Fiesta", Double.valueOf(1000)),
                new Vehiculo("Ford", "Focus", Double.valueOf(1200)),
                new Vehiculo("Ford", "Explorer", Double.valueOf(2500)),
                new Vehiculo("Fiat", "Uno", Double.valueOf(500)),
                new Vehiculo("Fiat", "Torino", Double.valueOf(1250)),
                new Vehiculo("Fiat", "Cronos", Double.valueOf(1000)),
                new Vehiculo("Chevrolet", "Aveo", Double.valueOf(1250)),
                new Vehiculo("Chevrolet", "Spin", Double.valueOf(2500)),
                new Vehiculo("Toyota", "Corolla", Double.valueOf(1200)),
                new Vehiculo("Toyota", "Fortuner", Double.valueOf(3000)),
                new Vehiculo("Renault", "Logan", Double.valueOf(950))
        );

        Garaje garaje = new Garaje(1, vehiculos);

        garaje.getVehiculos().stream().sorted(Comparator.comparingDouble(Vehiculo::getPrecio)).sorted(Comparator.comparing(Vehiculo::getMarca)).forEach(System.out::println);

        List<Vehiculo> vehiculosMin1000 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getPrecio() < 1000)
                .collect(Collectors.toList());
        List<Vehiculo> vehiculosMax1000 = garaje.getVehiculos().stream().filter(vehiculo -> vehiculo.getPrecio() >= 1000)
                .collect(Collectors.toList());

        System.out.println(vehiculosMin1000);
        System.out.println(vehiculosMax1000);

        OptionalDouble average = garaje.getVehiculos().stream().mapToDouble(vehiculo -> vehiculo.getPrecio()).average();
        System.out.println(String.format("%,.2f", average.getAsDouble()));
    }
}
