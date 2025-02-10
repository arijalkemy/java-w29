package Operaciones;

import Interfaces.Transaccion;

public class RetiroEfectivo implements Transaccion {
    @Override
    public void transaccionOk() {
        System.out.println("Realizándose retiro de efectivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Retiro de efectivo fallido");
    }
}