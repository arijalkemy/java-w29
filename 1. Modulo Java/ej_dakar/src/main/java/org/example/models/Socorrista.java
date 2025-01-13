package org.example.models;

public interface Socorrista<T extends Vehiculo> {

    void socorrer(T vehiculo);

}
