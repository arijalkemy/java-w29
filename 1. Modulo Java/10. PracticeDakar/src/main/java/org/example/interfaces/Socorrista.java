package org.example.interfaces;

import org.example.model.Vehiculo;

public interface Socorrista <T extends Vehiculo> {
    void socorrer(T vehiculo);
}
