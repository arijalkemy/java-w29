package org.example;

import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Vehiculo FordFiesta = new Vehiculo("Ford", "Fiesta", 1000);
        Vehiculo FordFocus = new Vehiculo("Ford", "Focus", 1200);
        Vehiculo FordExplorer = new Vehiculo("Ford", "Explorer", 2500);
        Vehiculo FiatUno = new Vehiculo("Fiat", "Uno", 500);
        Vehiculo FiatCronos = new Vehiculo("Fiat", "Cronos", 1000);
        Vehiculo FiatTorino = new Vehiculo("Fiat", "Torino", 1250);
        Vehiculo ChevroletAveo = new Vehiculo("Chevrolet", "Aveo", 1250);
        Vehiculo ChevroletSpin = new Vehiculo("Chevrolet", "Spin", 2500);
        Vehiculo ToyotaCorolla = new Vehiculo("Toyota", "Corolla", 1200);
        Vehiculo ToyotaFortuner = new Vehiculo("Toyota", "Fortuner", 3000);
        Vehiculo RenaultLogan = new Vehiculo("Renault", "Logan", 950);
        List<Vehiculo> vehiculos = List.of(FordFiesta, FordFocus, FordExplorer, FiatUno, FiatCronos,
                FiatTorino, ChevroletAveo, ChevroletSpin, ToyotaCorolla, ToyotaFortuner, RenaultLogan);

        Garage garage = new Garage(1, vehiculos);
        // Vehículos ordenados por precio de menor a mayor
        List<Vehiculo> vehiculosPrecio = vehiculos.stream().sorted(Comparator.comparingDouble(Vehiculo::getCosto)).toList();
        garage.setVehiculos(vehiculosPrecio);
        garage.mostrarVehiculos();


        System.out.println("Ordenando por atributo pasado por parámetro");
        garage.setVehiculos(vehiculos);
        List<Vehiculo> vehiculosOrdenados = garage.ordenarVehiculos(Vehiculo::getCosto);
        vehiculosOrdenados.forEach(System.out::println);
        System.out.println();

        // Lista ordenada por marca y a su vez por precio
        List<Vehiculo> vehiculosMarcaPrecio = vehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparingDouble(Vehiculo::getCosto))
                .toList();
        garage.setVehiculos(vehiculosMarcaPrecio);
        garage.mostrarVehiculos();

        // Vehículos con precio no mayor a 1000
        List<Vehiculo> vehiculosMenor1000 = vehiculos.stream().filter(veh -> veh.getCosto() < 1000).toList();
        garage.setVehiculos(vehiculosMenor1000);
        garage.mostrarVehiculos();

        // Vehículos con precios mayor o igual 1000
        List<Vehiculo> vehiculosMayor1000 = vehiculos.stream().filter(veh -> veh.getCosto() >= 1000).toList();
        garage.setVehiculos(vehiculosMayor1000);
        garage.mostrarVehiculos();

        // Promedio total de precios de toda la lista de vehículos
        Double promedioListaVehiculos = vehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0);
        System.out.printf("Promedio precio de vehículos: %.4f", promedioListaVehiculos);
    }
}
