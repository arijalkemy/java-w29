package com.mdaneri;

public class SocorristaMoto implements Socorredor<Moto> {

    @Override
    public void socorrer(Moto v) {
        System.out.println("Socorriendo moto: " + v.getPatente());
    }

}
