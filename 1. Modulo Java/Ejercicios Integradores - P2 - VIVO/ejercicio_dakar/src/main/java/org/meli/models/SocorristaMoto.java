package org.meli.models;

import org.meli.Socorrista;

public class SocorristaMoto implements Socorrista {
    @Override
    public void socorrer(Object moto) {
        System.out.println("Socorriendo moto con patente: " + ((Moto) moto).getPatente());
    }
}

