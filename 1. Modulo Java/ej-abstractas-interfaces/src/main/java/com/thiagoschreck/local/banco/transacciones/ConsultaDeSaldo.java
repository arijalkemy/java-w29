package com.thiagoschreck.local.banco.transacciones;

public class ConsultaDeSaldo implements Transaccion{
    @Override
    public void transaccionOk() {
        System.out.println("La consulta se ha realizado con éxito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("La consulta ha fallado.");
    }
}
