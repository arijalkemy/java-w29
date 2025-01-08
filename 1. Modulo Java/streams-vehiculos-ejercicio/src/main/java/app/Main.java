package app;

import models.Garaje;
import models.Vehiculo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Vehiculo> vehiculos = Arrays.asList(
              new Vehiculo("Ford", "Fiesta", 1000),
              new Vehiculo("Ford", "Focus", 1200),
              new Vehiculo("Ford", "Explorer", 2500),
              new Vehiculo("Fiat", "Uno", 500),
              new Vehiculo("Fiat", "Cronos", 1000),
              new Vehiculo("Fiat", "Torino", 1250),
              new Vehiculo("Chevrolet", "Aveo", 1250),
              new Vehiculo("Chevrolet", "Spin", 2500),
              new Vehiculo("Toyota", "Corolla", 1200),
              new Vehiculo("Toyota", "Fortnuer", 3000),
              new Vehiculo("Renault", "Logan", 950)
        );

        Garaje garaje = new Garaje(101, vehiculos);


        System.out.println("VEHICULOS ORDENADOS POR PRECIO");
        List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos()
                .stream()
                .sorted(Comparator.comparingInt(Vehiculo::getCosto))
                .toList();
        vehiculosOrdenados.forEach(System.out::println);

        System.out.println("VEHICULOS ORDENADOS POR PRECIO Y MARCA");
        garaje.getVehiculos().stream()
                .sorted(Comparator
                        .comparing(Vehiculo::getCosto)
                        .thenComparing(Vehiculo::getMarca))
                .forEach(System.out::println);

        //Vehiculos con precios menores a 1000
        System.out.println("VEHICULOS CON PRECIO MENOR A 1000");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() < 1000)
                .forEach(System.out::println);

        //Vehiculos con precios mayores o iguales a 1000
        System.out.println("VEHICULOS CON PRECIO MAYOR O IGUAL A 1000");
        garaje.getVehiculos().stream()
                .filter(vehiculo -> vehiculo.getCosto() >= 1000)
                .forEach(System.out::println);

        //Promedio
        double promedio = garaje.getVehiculos().stream()
                .mapToInt(Vehiculo::getCosto)
                .average()
                .orElse(0.0);
        System.out.printf("PROMEDIO DE COSTOS: %.2f", promedio);


    }
}
