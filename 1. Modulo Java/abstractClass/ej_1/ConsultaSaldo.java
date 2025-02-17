package com.example.demo.abstractClass.ej_1;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Consulta de saldo realizada con exito");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Error al realizar la consulta de saldo");
    }
}

