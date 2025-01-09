package com.thiagoschreck.local.banco.transacciones;

public class Transferencia implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La transferencia se ha realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La transferencia ha fallado.");
    }
}
