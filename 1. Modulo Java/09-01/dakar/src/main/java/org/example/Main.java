package org.example;

import org.example.model.Auto;
import org.example.model.Carrera;
import org.example.model.Vehiculo;

public class Main {
    public static void main(String[] args) {
        Carrera carrera = new Carrera(3000.00, 100000.00, "Carrera del desierto", 5);

        carrera.darDeAltaAuto(90.00, 6.00, 12.00, "AA150");
        carrera.darDeAltaAuto(170.00, 7.00, 88.00, "AB150");
        carrera.darDeAltaAuto(240.00, 8.00, 27.00, "AC150");

        carrera.darDeAltaMoto(140.00, 3.00, 43.00, "MA150");
        carrera.darDeAltaMoto(200.00, 4.00, 33.00, "MB150");
        carrera.darDeAltaMoto(130.00, 5.00, 23.00, "MC150");

        carrera.eliminarVehiculo("AA149");
        carrera.eliminarVehiculo("AA150");

        carrera.darDeAltaMoto(130.00, 5.00, 23.00, "MC150");

        carrera.socorrerAuto("MA150");
        carrera.socorrerAuto("AZ150");
        carrera.socorrerAuto("AB150");

        carrera.socorrerMoto("AB150");
        carrera.socorrerMoto("MZ150");
        carrera.socorrerMoto("MA150");

        carrera.obtenerGanador();

    }
}