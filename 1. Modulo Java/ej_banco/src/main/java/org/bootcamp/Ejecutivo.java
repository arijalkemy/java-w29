package org.bootcamp;

public class Ejecutivo implements Deposito, Transferencia{
    @Override
    public void hacerDeposito() {
        System.out.println("Se hizo el deposito del ejecutivo");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Se hizo la transferencia del ejecutivo");
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion no ok");
    }
}
