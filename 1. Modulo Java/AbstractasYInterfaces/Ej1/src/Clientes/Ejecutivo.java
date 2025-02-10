package Clientes;

import Interfaces.*;
import Operaciones.Deposito;
import Operaciones.Transferencia;

public class Ejecutivo {
    private Deposito deposito;
    private Transferencia transferencia;



    public void realizarDeposito() {
        Deposito deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void realizarTransferencia() {
        Transferencia transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}