package integrador_p2_e2.Socorristas;

import integrador_p2_e2.Vehiculo;

public interface Socorrista<T extends Vehiculo> {
    void socorrer(T vehiculo);
}
