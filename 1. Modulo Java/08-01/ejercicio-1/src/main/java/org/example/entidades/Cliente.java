package org.example.entidades;

import org.example.interfaces.Transaccion;

public abstract class Cliente implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transaccion Ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }
}
