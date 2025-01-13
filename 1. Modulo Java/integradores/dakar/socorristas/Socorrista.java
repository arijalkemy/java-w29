package com.example.demo.integradores.dakar.socorristas;

import com.example.demo.integradores.dakar.Vehiculo;

public interface Socorrista<T extends Vehiculo> {
    void socorrer(T vehiculo);
}
