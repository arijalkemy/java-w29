package org.example;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Garaje garaje = new Garaje(1, Arrays.asList(
                new Vehiculo("Ford", "Fiesta", 1000.00),
                new Vehiculo("Ford", "Focus", 1200.00),
                new Vehiculo("Ford", "Explorer", 2500.00),
                new Vehiculo("Fiat", "Uno", 500.00),
                new Vehiculo("Fiat", "Cronos", 1000.00),
                new Vehiculo("Fiat", "Torino", 1250.00),
                new Vehiculo("Chevrolet", "Aveo", 1250.00),
                new Vehiculo("Chevrolet", "Spin", 2500.00),
                new Vehiculo("Toyota", "Corola", 1200.00),
                new Vehiculo("Toyota", "Fortuner", 3000.00),
                new Vehiculo("Renault", "Logan", 950.00)
        ));

        // Ejercicio 3
        List<Vehiculo> ordenadosPrecio = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getPrecio))
                .toList();
        System.out.println("-------------- ORDENADOS POR PRECIO --------------");
        ordenadosPrecio.forEach(System.out::println);
        System.out.println();

        // Ejercicio 4
        List<Vehiculo> ordenadosMarcaPrecio = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getPrecio))
                .toList();
        System.out.println("-------------- ORDENADOS POR MARCA Y PRECIO --------------");
        ordenadosMarcaPrecio.forEach(System.out::println);
        System.out.println();

        // Ejercicio 5
        List<Vehiculo> menoresA1000 = garaje.getVehiculos()
                .stream()
                .filter(v -> v.getPrecio() < 1000.00)
                .toList();
        System.out.println("-------------- MENORES A 1000 --------------");
        menoresA1000.forEach(System.out::println);
        System.out.println();

        List<Vehiculo> mayoresA1000 = garaje.getVehiculos()
                .stream()
                .filter(v -> v.getPrecio() >= 1000.00)
                .toList();
        System.out.println("-------------- MAYORES O IGUALES A 1000 --------------");
        mayoresA1000.forEach(System.out::println);
        System.out.println();

        Double promedio = garaje.getVehiculos()
                .stream()
                .mapToDouble(Vehiculo::getPrecio)
                .average()
                .orElse(0.0);
        System.out.println("-------------- PROMEDIO DE PRECIOS --------------");
        System.out.println(promedio);
        System.out.println();
    }
}