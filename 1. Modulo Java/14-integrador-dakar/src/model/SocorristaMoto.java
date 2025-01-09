package model;

public class SocorristaMoto implements Socorrista<Moto>{
    @Override
    public void socorrer(Moto vehiculo) {
        System.out.println("Socorriendo moto: " + vehiculo.getPatente());
    }
}
