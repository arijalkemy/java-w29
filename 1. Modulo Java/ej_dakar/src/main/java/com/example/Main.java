package com.example;

import com.example.model.Auto;
import com.example.model.Carrera;

public class Main {

    public static void main(String[] args) {
        Auto auto1 = new Auto(300.0, 100.0, 75.0, "AJK 197");

        Carrera granPrixDeEdu = Carrera.builder()
                .nombre("Gran Prix de Edu")
                .precioEnDolares(1000.0)
                .distancia(174.5)
                .cantidadDeVehiculosPermitidos(3)
                .build();

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.eliminarVehiculo(auto1);
        granPrixDeEdu.darDeAltaAuto(300.0, 100.0, 75.0, "AJK 197");
        granPrixDeEdu.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");
        granPrixDeEdu.darDeAltaAuto(270.0, 84.0, 90.0, "PPP 223");

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.darDeAltaMoto(150.0, 59.7, 34.2, "MOT 069");
        granPrixDeEdu.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");
        granPrixDeEdu.eliminarVehiculoConPatente("MOT 069");
        granPrixDeEdu.darDeAltaMoto(350.0, 7.3, 150.0, "ONE 234");

        System.out.println("----------------------------------------------------------------------------------");

        granPrixDeEdu.socorrer(auto1);
    }

}
