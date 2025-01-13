package org.example.models;

public class SocorristaAuto implements Socorrista<Auto> {

    @Override
    public void socorrer(Auto vehiculo) {
        System.out.println("Socorriendo auto " + vehiculo.getPatente());
    }

}
