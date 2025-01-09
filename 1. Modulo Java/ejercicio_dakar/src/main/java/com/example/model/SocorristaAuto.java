package com.example.model;

public class SocorristaAuto implements Socorrista<Auto>{

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto con patente: " + auto.getPatente());
    }
}
