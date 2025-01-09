package org.meli;

import org.meli.models.Carrera;
import org.meli.models.Vehiculo;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(500.0, 10000.0, "la gran carrera", 5, new ArrayList<>());

        carrera.darDeAltaAuto(120.0, 10.0, 15.0, "ABC123");
        carrera.darDeAltaMoto(100.0, 12.0, 20.0, "MOT456");

        System.out.println("Vehículos inscritos:");
        carrera.getVehiculos().forEach(v -> System.out.println(v.getPatente()));

        Vehiculo ganador = carrera.determinarGanador();
        System.out.println("El ganador es el vehículo con patente: " + (ganador != null ? ganador.getPatente() : "Ninguno"));

        carrera.socorrerAuto("ABC123");
        carrera.socorrerMoto("MOT456");
    }
}