package org.Clases;

import org.Interfaces.Deposito;
import org.Interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {

    @Override
    public void HacerDeposito() {
        System.out.println("Haciendo deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Haciendo transferencia");

    }

    @Override
    public void transaccionOK() {
        System.out.println("Transaccion OK");

    }

    @Override
    public void transaccionNoOK() {
        System.out.println("Transaccion no OK");

    }
}
