package org.example;

import java.util.Arrays;
import java.util.Comparator;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        Garaje garaje = new Garaje(34, Arrays.asList(
                new Vehiculo("Ford", "2020", 4000),
                new Vehiculo("Ford", "Fiesta", 4000),
                new Vehiculo("Ford", "Focus", 4000),
                new Vehiculo("Ford", "Explorer", 2500),
                new Vehiculo("Fiat", "Uno", 500),
                new Vehiculo("Fiat", "Cronos", 1000),
                new Vehiculo("Fiat", "Torino", 1250),
                new Vehiculo("Chevrolet", "Aveo", 1250),
                new Vehiculo("Chevrolet", "Spin", 2500),
                new Vehiculo("Toyota", "Corola", 1200),
                new Vehiculo("Toyota", "Fortuner", 3000),
                new Vehiculo("Renault", "Logan", 950)
        ));

        //Vehiculos ordenados por precio
        System.out.println("La lista ordenada por precios es: ");
        garaje.getVehiculosbyprecio().forEach(System.out::println);

        //Vehiculos ordenados por Marca y Precio
        System.out.println("----------------------------");
        System.out.println("Vehiculos ordenados por Marca y Precio");
        garaje.getVehiculosbyMarcaYPrecio().forEach(System.out::println);

        //Vehiculos ordenados por Precio menor a 1000
        System.out.println("----------------------------");
        System.out.println("Vehiculos ordenados por Precio < 1000");
        garaje.getVehiculosMenorCostoMaximo().forEach(System.out::println);

        //Vehiculos ordenados por precio igual mayor a 1000
        System.out.println("----------------------------");
        System.out.println("Vehiculos ordenados por Precio >= 1000");
        garaje.getVehiculosMayorQue().forEach(System.out::println);


        //Promedio total de los precios de los vehiculos
        System.out.println("----------------------------");
        System.out.println("Promedio total de los precios de los vehiculos: " + garaje.getPromedioVehiculos());



    }
}