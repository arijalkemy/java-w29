package com.thiago.local;

import com.thiago.local.transporte.Garage;
import com.thiago.local.transporte.Vehiculo;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Garage garage = new Garage(1, List.of(
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
        ));

        System.out.println("Vehiculos ordenados por precio ascendente");
        garage.listarPorPrecioAscendente();
        System.out.println("------");
        System.out.println("Vehiculos ordenados por marca y precio ascendentes");
        garage.listarPorMarcaYPrecioAscendente();
        System.out.println("------");
        System.out.println("Vehiculos con precio menor a 1000");
        garage.obtenerVehiculosConPrecioMenorA(1000).forEach(System.out::println);
        System.out.println("------");
        System.out.println("Vehiculos con precio mayor o igual a 1000");
        garage.obtenerVehiculosConPrecioMayorOIgualA(1000).forEach(System.out::println);
        System.out.println("------");
        System.out.printf("El promedio es %s%n", garage.obtenerPromedioPrecios());
    }
}
