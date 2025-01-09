package org.meli.models;

import org.meli.Socorrista;

public class SocorristaAuto implements Socorrista<Auto> {

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto con patente: " + auto.getPatente());
    }
}