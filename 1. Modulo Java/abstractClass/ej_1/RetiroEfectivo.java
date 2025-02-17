package com.example.demo.abstractClass.ej_1;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Retiro de efectivo realizado con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el retiro de efectivo.");
    }
}
