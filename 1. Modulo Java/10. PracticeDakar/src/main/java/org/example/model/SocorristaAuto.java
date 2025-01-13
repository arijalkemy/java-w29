package org.example.model;

import org.example.interfaces.Socorrista;

public class SocorristaAuto implements Socorrista {

    @Override
    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Auto) {
            System.out.println("Socorriendo auto");
        } else {
            throw new IllegalArgumentException("Este socorrista solo repara autos");
        }
    }
}
