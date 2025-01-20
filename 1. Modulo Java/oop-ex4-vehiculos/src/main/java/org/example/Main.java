package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        List<Vehiculo> misVehiculos = new ArrayList<>();

        misVehiculos.add(new Vehiculo("Ford","Fiesta",1000d));
        misVehiculos.add(new Vehiculo("Ford","Focus",1200d));
        misVehiculos.add(new Vehiculo("Ford","Explorer",2500d));
        misVehiculos.add(new Vehiculo("Fiat","Uno",500d));
        misVehiculos.add(new Vehiculo("Fiat","Cronos",1000d));
        misVehiculos.add(new Vehiculo("Fiat","Torino",1250d));
        misVehiculos.add(new Vehiculo("Chevrolet","Aveo",1250d));
        misVehiculos.add(new Vehiculo("Chevrolet","Spin",2500d));
        misVehiculos.add(new Vehiculo("Toyota","Corola",1250d));
        misVehiculos.add(new Vehiculo("Toyota","Fortuner",3000d));
        misVehiculos.add(new Vehiculo("Renault","Logan",950d));

        Garage garage = new Garage("1",misVehiculos);

        System.out.println("Lista ordenada de menor a mayor");

        misVehiculos.stream()
                .sorted((v1, v2) -> Double.compare(v1.getCosto(), v2.getCosto()))
                .forEach(System.out::println);

        System.out.println("Ordenado por Marca primero y despues por Precio");
        misVehiculos.stream()
                .sorted(Comparator.comparing(Vehiculo::getMarca)
                        .thenComparing(Vehiculo::getCosto))
                .forEach(System.out::println);

        System.out.println("Menores a 1000");
        misVehiculos.stream().filter(v -> v.getCosto() < 1000).findFirst().ifPresent(System.out::println);
        System.out.println("Mayores o igual a 1000");
        misVehiculos.stream().filter(p->p.getCosto() >= 1000).findFirst().ifPresent(System.out::println);

        System.out.println(misVehiculos.stream().mapToDouble(Vehiculo::getCosto).average().orElse(0.0));;


    }
}