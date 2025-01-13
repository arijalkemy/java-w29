package integrador_p2_e2.Socorristas;

import integrador_p2_e2.Motos;

public class SocorristaMoto implements Socorrista<Motos> {
    @Override
    public void socorrer(Motos moto) {
        System.out.println("Socorriendo moto " + moto);
    }
}
