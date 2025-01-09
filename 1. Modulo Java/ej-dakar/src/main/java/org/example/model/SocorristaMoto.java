package org.example.model;

public class SocorristaMoto implements Socorrista<Moto> {
    @Override
    public void socorrer(Moto moto) {
        System.out.printf("Socorriendo moto %s", moto.getPatente());
    }
}
