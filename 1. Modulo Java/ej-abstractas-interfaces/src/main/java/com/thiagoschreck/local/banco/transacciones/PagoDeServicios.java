package com.thiagoschreck.local.banco.transacciones;

public class PagoDeServicios implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("El pago se ha realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("El pago ha fallado.");
    }
}
