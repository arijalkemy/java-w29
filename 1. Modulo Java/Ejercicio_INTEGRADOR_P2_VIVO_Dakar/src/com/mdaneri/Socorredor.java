package com.mdaneri;

public interface Socorredor<T extends Vehiculo> {
    void socorrer(T v);
}
