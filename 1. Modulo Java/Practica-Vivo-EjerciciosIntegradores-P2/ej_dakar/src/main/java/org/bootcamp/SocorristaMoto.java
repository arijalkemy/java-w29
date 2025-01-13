package org.bootcamp;

public class SocorristaMoto implements Socorrista<Moto> {

    @Override
    public void socorrer(Moto moto) {
        System.out.println("Socorrista moto: " + moto.getPatente());
    }
}
