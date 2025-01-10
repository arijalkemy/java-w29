package org.bootcamp;

public interface Socorrista<T extends Vehiculo> {
    void socorrer(T vehiculo);
}
