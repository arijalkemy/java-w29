package com.example.demo.abstractClass.ej_1;

public class Transferencia implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Transferencia realizada con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la transferencia.");
    }
}
