package classes;

import interfaces.Deposito;
import interfaces.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {
    @Override
    public void hacerDeposito() {
        System.out.println("classes.Ejecutivo hace deposito");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("classes.Ejecutivo hace transferencia");
    }

    @Override
    public void transaccionOk() {
        System.out.println("classes.Ejecutivo transaccion ok");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println("classes.Ejecutivo transaccion no ok");
    }
}
