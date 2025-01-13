package integrador_p2_e2.Socorristas;

import integrador_p2_e2.Autos;

public class SocorristaAuto implements Socorrista<Autos> {
    @Override
    public void socorrer(Autos auto) {
        System.out.println("Socorriendo auto " + auto);
    }
}
