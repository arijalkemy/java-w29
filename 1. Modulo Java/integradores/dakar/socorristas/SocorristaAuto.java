package com.example.demo.integradores.dakar.socorristas;

import com.example.demo.integradores.dakar.Auto;

public class SocorristaAuto implements Socorrista<Auto> {

    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto con patente: " + vehiculo.getPatente());

    }
}
