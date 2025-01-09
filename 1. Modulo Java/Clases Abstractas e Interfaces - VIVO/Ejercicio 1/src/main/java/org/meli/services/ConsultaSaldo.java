package org.meli.services;

import org.meli.interfaces.Transaccion;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo exitosa.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al consultar el saldo.");
    }
}
