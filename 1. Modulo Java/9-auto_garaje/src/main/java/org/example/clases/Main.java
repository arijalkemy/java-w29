package org.example.clases;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Garaje g = new Garaje(1);
        g.agregarVehiculo(new Auto("Fiesta", "Ford", 1000.0));
        g.agregarVehiculo(new Auto("Focus", "Ford", 1200.0));
        g.agregarVehiculo(new Auto("Explorer", "Ford", 2500.0));
        g.agregarVehiculo(new Auto("Uno", "Fiat", 500.0));
        g.agregarVehiculo(new Auto("Cronos", "Fiat", 1000.0));
        g.agregarVehiculo(new Auto("Torino", "Fiat", 1250.0));
        g.agregarVehiculo(new Auto("Aveo", "Chevrolet", 1250.0));
        g.agregarVehiculo(new Auto("Spin", "Chevrolet", 2500.0));
        g.agregarVehiculo(new Auto("Corola", "Toyota", 1200.0));
        g.agregarVehiculo(new Auto("Fortuner", "Toyota", 3000.0));
        g.agregarVehiculo(new Auto("Logan", "Renault", 950.0));

        //Haciendo uso del método sort en la lista de Vehículos con expresiones lambda,
        // obtén una lista de vehículos ordenados por precio de menor a mayor, imprime por pantalla el resultado.
        List<Auto> listVehiculos = g.getAutos();


        System.out.println("Vehículos ordenados por precio (menor a mayor):");
        listVehiculos
                .stream()
                .sorted((a1,a2)-> Double.compare(a1.getPrecio(), a2.getPrecio()))
                .forEach(System.out::println);


        //De la misma forma que el ejercicio anterior, imprime una lista ordenada por marca y a su vez por precio.
        System.out.println("\nVehículos ordenados por marca y precio:");
        listVehiculos
                .stream()
                .sorted(Comparator
                        .comparing(Auto::getMarca)
                        .thenComparingDouble(Auto::getPrecio))
                .forEach(System.out::println);



        // Se desea extraer una lista de vehículos con precio no mayor a 1000, luego otra con precios
        // mayor o igual 1000 y por último, obtén el promedio total de precios de toda la lista de vehículos.

        // Obtener y mostrar lista de vehículos con precio menor a 1000
        System.out.println("\nVehículos con precio menor a 1000:");
        List<Auto> listMenor1000 = g.getAutos().stream().filter(auto -> auto.getPrecio() < 1000).toList();
        System.out.println(listMenor1000);


        // Obtener y mostrar lista de vehículos con precio mayor o igual a 1000
        System.out.println("\nVehículos con precio mayor o igual a 1000:");
        List<Auto> listMayor1000 = g.getAutos().stream().filter(auto -> auto.getPrecio() >= 1000).toList();
        System.out.println(listMayor1000);

        // Calcular y mostrar el promedio de precios
        Double precioProm = listVehiculos.stream()
                        .mapToDouble(Auto::getPrecio).average().getAsDouble();
        System.out.println("\nPromedio de precios de los vehículos: " +precioProm);


    }
}