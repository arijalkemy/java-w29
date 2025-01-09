package com.thiagoschreck.local.banco.transacciones;

public class RetiroDeEfectivo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("El retiro se ha realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El retiro ha fallado.");
    }
}
