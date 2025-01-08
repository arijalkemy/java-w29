package org.ejercicio1;

public class Ejecutivo extends Cliente implements Deposito, Transferencia {

    @Override
    public void hacerDeposito() {
        System.out.println("Haciendo deposito");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("Transaccion no ok");
    }

    @Override
    public void hacerTrasferencia(double monto) {
        if (monto <= getSaldoTotal()){
            double saldoFinal = getSaldoTotal() - monto;
            setSaldoTotal(saldoFinal);
            transaccionOk();
        } else {
            transaccionNoOk();
        }
    }
}
