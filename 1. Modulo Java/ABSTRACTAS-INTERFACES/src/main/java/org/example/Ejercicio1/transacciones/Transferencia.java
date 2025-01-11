package org.example.Ejercicio1.transacciones;

public class Transferencia implements Transaccion {
    @Override
    public void ok() {
        System.out.println("Realizando transferencia: ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando transferencia: no Ok");
    }
}
