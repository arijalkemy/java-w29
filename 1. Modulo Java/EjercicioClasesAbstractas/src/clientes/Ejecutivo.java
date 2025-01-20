package clientes;

import transacciones.Deposito;
import transacciones.Transferencia;

public class Ejecutivo {
    public void deposito() {
        Deposito deposito = new Deposito();
        deposito.doTransaction();
    }
    public void transferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.doTransaction();
    }
}
