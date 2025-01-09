package com.thiagoschreck.local.banco.transacciones;

public class Deposito implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("El depósito se ha realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El depósito ha fallado.");
    }
}
