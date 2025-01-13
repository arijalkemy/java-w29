package com.example.demo.ejercicio_integrador_lambdas.Ejercicio_1;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        /*
        Ej 2
        Haz una clase Main con el método main para representar un escenario donde se crea una instancia
        de la clase garaje con una lista de vehículos según la tabla.
         */
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

        Garaje garaje = new Garaje(1);
        garaje.setVehiculos(vehiculos);


        /*
        Ejercicio 3
        Haciendo uso del método sort en la lista de Vehículos con expresiones lambda, obtén una lista de vehículos
        rdenados por precio de menor a mayor, imprime por pantalla el resultado.
         */
        List<Vehiculo> vehiculosOrdenados = garaje.getVehiculos();
        vehiculosOrdenados.sort( (v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                ;

        // vehiculosOrdenados.forEach(System.out::println);
        /*
        Ejercicio 4
        De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
         */
        vehiculosOrdenados.sort( (v1, v2) -> v1.getMarca().compareTo(v2.getMarca()));
        System.out.println("Ordenados por Marca y Costo");
        // ordenado por precio y marca
        vehiculosOrdenados.forEach(System.out::println);

        /*
        Ejercicio 5
        Se desea extraer una lista de vehículos con precio no mayor a 1000,
        luego otra con precios mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista
        de vehículos.
         */



    }
}
