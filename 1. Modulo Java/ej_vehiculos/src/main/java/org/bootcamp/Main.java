package org.bootcamp;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.OptionalDouble;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(new Vehiculo("Ford", "Fiesta", 1000d));
        vehiculos.add(new Vehiculo("Ford", "Focus", 1200d));
        vehiculos.add(new Vehiculo("Ford", "Explorer", 2500d));
        vehiculos.add(new Vehiculo("Fiat", "Uno", 500d));
        vehiculos.add(new Vehiculo("Fiat", "Cronos", 1000d));
        vehiculos.add(new Vehiculo("Fiat", "Torino", 1250d));
        vehiculos.add(new Vehiculo("Chevrolet", "Aveo", 1250d));
        vehiculos.add(new Vehiculo("Chevrolet", "Spin", 2500d));
        vehiculos.add(new Vehiculo("Toyota", "Corola", 1200d));
        vehiculos.add(new Vehiculo("Toyota", "Fortuner", 3000d));
        vehiculos.add(new Vehiculo("Renault", "Logan", 950d));

        Garage garage = new Garage(1, vehiculos);

        vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("--------------------------");

        vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca).thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("--------------------------");

        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < 1000d)
                .forEach(System.out::println);

        System.out.println("--------------------------");

        vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= 1000d)
                .forEach(System.out::println);

        OptionalDouble average = vehiculos.stream().mapToDouble(Vehiculo::getCosto)
                .average();
        System.out.println("Promedio: " + average.getAsDouble());
    }
}