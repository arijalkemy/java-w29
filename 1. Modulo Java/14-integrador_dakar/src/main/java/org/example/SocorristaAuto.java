package org.example;

public class SocorristaAuto implements Socorrista {

    @Override
    public void socorrer(Object auto) {
        System.out.println("Socorriendo auto con patente: " + ((Autos) auto).getPatente());

    }
}
