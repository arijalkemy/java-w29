package org.example;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500.0, 10000.0, "Carrera monaco", 8, new ArrayList<>());

        carrera.darDeAltaAuto(150, 11.0, 15.0, "HRE123");
        carrera.darDeAltaMoto(120, 12.0, 20.0, "NZO456");

        System.out.println("Vehículos inscritos:");
        carrera.getVehiculos().forEach(v -> System.out.println(v.getPatente()));

        Vehiculo ganador = carrera.determinarGanador();
        System.out.println("El ganador es el vehículo con patente: " + (ganador != null ? ganador.getPatente() : "Ninguno"));

        carrera.socorrerAuto("HRE123");
        carrera.socorrerMoto("NZO456");
    }
}