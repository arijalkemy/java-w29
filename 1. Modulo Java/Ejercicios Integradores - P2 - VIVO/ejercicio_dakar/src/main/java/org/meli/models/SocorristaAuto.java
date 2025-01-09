package org.meli.models;

import org.meli.Socorrista;

public class SocorristaAuto implements Socorrista {

    @Override
    public void socorrer(Object auto) {
        System.out.println("Socorriendo auto con patente: " + ((Auto) auto).getPatente());
    }
}

