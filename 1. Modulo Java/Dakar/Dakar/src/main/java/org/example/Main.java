package org.example;

import model.Auto;
import model.Carrera;
import model.Moto;

import java.io.CharArrayReader;

public class Main {
    public static void main(String[] args) {

        Carrera dakar = new Carrera(1000.00, 100,"Dakar",100);

        dakar.darDeAltaAuto(100.00,250.00, 45.0,"NBJ104");
        dakar.darDeAltaAuto(85.00,350.00, 30.0,"NBJ105");
        dakar.darDeAltaMoto(75.00,190.00, 60.0,"NBJ106");
        dakar.darDeAltaMoto(112.00,210.00, 75.0,"NBJ107");
        dakar.darDeAltaMoto(112.00,210.00, 75.0,"NBJ108");

        dakar.eliminarVehiculoConPatente("NBJ108");

        dakar.socorrerAuto("NBJ105");
        dakar.socorrerMoto("NBJ106");

        System.out.println("El vehiculo ganador es el siguiente: " + dakar.vehiculoGanador().toString());
    }
}