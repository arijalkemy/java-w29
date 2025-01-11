package org.example.Ejercicio1.transacciones;

public class ConsultaSaldo implements Transaccion {
    @Override
    public void ok() {
        System.out.println("Realizando consulta saldo: Ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando consulta saldo: no Ok");
    }
}
