package org.example.model;

public class SocorristaAuto implements Socorrista<Auto> {
    @Override
    public void socorrer(Auto auto) {
        System.out.printf("Socorriendo auto %s", auto.getPatente());
    }
}
