package com.integrador.dakar;

public interface Socorrista<T extends Vehiculo> {
    void socorrer(T vehiculo);
}