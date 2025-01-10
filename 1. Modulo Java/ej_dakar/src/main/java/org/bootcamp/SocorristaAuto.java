package org.bootcamp;

public class SocorristaAuto implements Socorrista<Auto> {

    @Override
    public void socorrer(Auto auto) {
        System.out.println("Socorriendo auto: " + auto.getPatente());
    }
}
