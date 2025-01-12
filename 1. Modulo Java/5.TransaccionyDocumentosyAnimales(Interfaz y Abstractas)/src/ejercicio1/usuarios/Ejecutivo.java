package ejercicio1.usuarios;

import ejercicio1.transacciones.Deposito;
import ejercicio1.transacciones.Transaccion;
import ejercicio1.transacciones.Transferencia;

import java.util.ArrayList;
import java.util.List;

public class Ejecutivo {

    Deposito deposito;
    Transferencia transferencia;

    public Ejecutivo() {
        deposito = new Deposito();
        transferencia = new Transferencia();
    }

    public void realizarDepositoOk() {
        this.deposito.ok();
    }

    public void realizarDepositoNoOk() {
        this.deposito.noOk();
    }

    public void realizarTransferenciaOk() {
        this.transferencia.ok();
    }

    public void realizarTransferenciaNoOk() {
        this.transferencia.noOk();
    }
}
