package org.example.model;

import org.example.interfaces.Socorrista;

public class SocorristaMoto implements Socorrista {

    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Moto) {
            System.out.println("Socorriendo moto");
        } else {
            throw new IllegalArgumentException("Este socorrista solo repara motos");
        }
    }
}
