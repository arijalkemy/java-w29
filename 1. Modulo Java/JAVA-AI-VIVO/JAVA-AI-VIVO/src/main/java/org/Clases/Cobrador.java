package org.Clases;

import org.Interfaces.Retiro;
import org.Interfaces.Saldo;

public class Cobrador implements Retiro, Saldo {
    @Override
    public void HacerRetiro() {

        System.out.println("Haciendo retiro");
    }

    @Override
    public void consultaSaldo() {
        System.out.println("Consultando saldo");

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
