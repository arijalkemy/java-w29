package Ex1.Clases;


import Ex1.Transactions.Deposito;
import Ex1.Transactions.Transferencia;

public class Ejecutivo implements Deposito, Transferencia {


    @Override
    public void hacerDeposito() {
        System.out.println("Intentando hacer depósito...");
    }

    @Override
    public void transaccionOk() {
        System.out.println("Operacion alizada correctamente por usuario Ejecutivo");
    }

    @Override
    public void transaccionNoOk() {
        System.out.println( "Error al realizar la operación");
    }

    @Override
    public void hacerTransferencia() {
        System.out.println("Intentando hacer transferencia...");
    }
}
