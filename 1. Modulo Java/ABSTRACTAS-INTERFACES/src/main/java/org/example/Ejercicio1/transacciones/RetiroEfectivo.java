package org.example.Ejercicio1.transacciones;

public class RetiroEfectivo implements Transaccion {

    @Override
    public void ok() {
        System.out.println("Realizando Retiro Efectivo: Ok");
    }

    @Override
    public void noOk() {
        System.out.println("Realizando Retiro Efectivo: no Ok");
    }
}
