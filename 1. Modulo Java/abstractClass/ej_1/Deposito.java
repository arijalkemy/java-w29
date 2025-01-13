package com.example.demo.abstractClass.ej_1;

public class Deposito implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Deposito realizado con exito.");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar el deposito.");
    }
}
