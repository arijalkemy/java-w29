package com.mdaneri;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950));

        Garaje garaje = new Garaje(0, vehiculos);

        // Ejercicio 3: Ordenar los autos por precio de menor a mayor
        garaje.getVehiculos().sort((o1, o2) -> {
            return Double.compare(o1.getCosto(), o2.getCosto());
        });

        // Ejercicio 4: Ordenar por marca & precio.
        garaje.getVehiculos().sort(new Comparator<Vehiculo>() {
            @Override
            public int compare(Vehiculo o1, Vehiculo o2) {
                if (o1.getMarca().equals(o2.getMarca()))
                   return Double.compare(o1.getCosto(), o2.getCosto());
                return o1.getMarca().compareTo(o2.getMarca());
            }
        });
        garaje.getVehiculos().forEach(System.out::println);

        // Ejercicio 5: Sublista de vehiculo con costo menor o igual a $1000 y luego, obtener su promedio de precio.
        System.out.println("Vehículos con precios menor o igual a $1000");
        List<Vehiculo> preciosMenores = garaje.getVehiculos()
                .stream()
                .filter((vehiculo -> vehiculo.getCosto() <= 1000))
                .toList();
        preciosMenores.forEach(System.out::println);

        System.out.println("Vehículos con precios mayor o igual a $1000");
        List<Vehiculo> preciosMayores = garaje.getVehiculos()
                .stream()
                .filter((vehiculo -> vehiculo.getCosto() >= 1000))
                .toList();
        preciosMayores.forEach(System.out::println);

        System.out.print("Promedio de precio: ");
        double avg = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
        System.out.println(avg);

    }
}