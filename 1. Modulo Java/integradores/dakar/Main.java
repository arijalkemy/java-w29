package com.example.demo.integradores.dakar;

import com.example.demo.integradores.dakar.CRUD.CarreraRepository;

public class Main {
    public static void main(String[] args) {
        // CarreraRepository carreraRepository = new CarreraRepository();

        Carrera carrera = new Carrera(5000, 10000, "Gran Premio", 5);

        carrera.darDeAltaAuto(150, 10, 30, "ABC123");
        carrera.darDeAltaAuto(180, 12, 25, "DEF456");

        carrera.darDeAltaMoto(200, 15, 20, "GHI789");
        carrera.darDeAltaMoto(220, 18, 15, "JKL012");

        carrera.darDeAltaAuto(170, 11, 28, "MNO345");

        System.out.println("Vehiculos en la carrera:");
        carrera.getVehiculos().forEach(v -> System.out.println("Patente: " + v.getPatente()));

        Vehiculo vehiculoAEliminar = carrera.getVehiculos().getFirst();
        carrera.eliminarVehiculo(vehiculoAEliminar);
        System.out.println("\nVehiculo eliminado por objeto: " + vehiculoAEliminar.getPatente());

        carrera.eliminarVehiculoConPatente("JKL012");
        System.out.println("\nVehículo eliminado por patente: JKL012");

        System.out.println("\nVehículos restantes en la carrera:");
        carrera.getVehiculos().forEach(v -> System.out.println("Patente: " + v.getPatente()));

        Vehiculo ganador = carrera.definirGanador();
        System.out.println("\nEl ganador de la carrera es el vehículo con patente: " + ganador.getPatente());

        carrera.socorrerAuto("DEF456");
        carrera.socorrerMoto("GHI789");
    }
}
