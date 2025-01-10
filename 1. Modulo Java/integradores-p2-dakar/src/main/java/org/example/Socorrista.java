package org.example;

public interface Socorrista<T extends Vehiculo>{
    void socorrer(T vehiculo);
}