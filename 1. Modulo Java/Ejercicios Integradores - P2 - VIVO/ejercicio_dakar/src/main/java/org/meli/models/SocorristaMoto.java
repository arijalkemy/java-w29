package org.meli.models;

import org.meli.Socorrista;

public class SocorristaMoto implements Socorrista<Moto> {
    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorriendo moto con patente: " + moto.getPatente());
    }
}