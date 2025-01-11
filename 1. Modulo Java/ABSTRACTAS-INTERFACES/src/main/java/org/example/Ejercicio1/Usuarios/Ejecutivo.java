package org.example.Ejercicio1.Usuarios;

import org.example.Ejercicio1.transacciones.Deposito;
import org.example.Ejercicio1.transacciones.Transferencia;

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
