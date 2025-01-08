package models.clientes;

import models.transacciones.Deposito;
import models.transacciones.Transaccion;
import models.transacciones.Transferencia;

public class Ejecutivo extends Cliente {

    public Ejecutivo(String nombre){
        super(nombre);
    }

    public void realizarDeposito() {
        System.out.printf("Cliente Ejecutivo '%s' realizando deposito%n", this.getNombre());
        Transaccion deposito = new Deposito();
        deposito.transaccionOk();
    }

    public void realizarTransferencia() {
        System.out.printf("Cliente Ejecutivo '%s' realizando transferencia%n", this.getNombre());
        Transaccion transferencia = new Transferencia();
        transferencia.transaccionOk();
    }
}
