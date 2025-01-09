package org.meli;

import org.meli.models.Garaje;
import org.meli.models.Vehiculo;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        //2
        Garaje garaje = new Garaje(1);

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

        System.out.println("\nVehículos en el garaje:");
        garaje.getVehiculos().forEach(System.out::println);


        //3
        garaje.getVehiculos().sort((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()));

        System.out.println("\nVehículos ordenados por precio de menor a mayor:");
        garaje.getVehiculos().forEach(System.out::println);


        //4
        garaje.getVehiculos().sort((v1, v2) -> {
            int comparacionMarca = v1.getMarca().compareTo(v2.getMarca());
            if (comparacionMarca == 0) {
                return Double.compare(v1.getCosto(), v2.getCosto());
            }
            return comparacionMarca;
        });

        System.out.println("\nVehículos ordenados por marca y por precio:");
        garaje.getVehiculos().forEach(System.out::println);

        //5
        List<Vehiculo> precioNoMayor1000 = garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() <= 1000)
                .collect(Collectors.toList());

        System.out.println("\nVehículos con precio no mayor a 1000:");
        precioNoMayor1000.forEach(System.out::println);


        List<Vehiculo> precioMayorIgualA1000 = garaje.getVehiculos().stream()
                .filter(v -> v.getCosto() >= 1000)
                .collect(Collectors.toList());


        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        precioMayorIgualA1000.forEach(System.out::println);


        double promedioCostos = garaje.getVehiculos().stream()
                .mapToDouble(Vehiculo::getCosto)
                .average()
                .orElse(0);
        System.out.println("\nPromedio de precios de todos los vehículos: " + promedioCostos);
    }
}