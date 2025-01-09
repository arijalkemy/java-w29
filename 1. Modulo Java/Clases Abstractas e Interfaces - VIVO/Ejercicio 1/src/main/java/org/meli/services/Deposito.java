package org.meli.services;

import org.meli.interfaces.Transaccion;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Depósito realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el depósito.");
    }
}
