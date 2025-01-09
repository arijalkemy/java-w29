package com.mdaneri;

public class SocorristaAuto implements Socorredor<Auto> {

    public void socorrer(Auto v) {
        System.out.println("Socorriendo auto: " + v.getPatente());
    }

}
