package org.meli.models;

import org.meli.interfaces.Transaccion;

public abstract class Cliente {
    String nombre;

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public abstract void realizarTransaccion(Transaccion transaccion, boolean exito);
}
