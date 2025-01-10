package org.example.clases;

import org.example.interfaces.Deposito;
import org.example.interfaces.Transferencia;

public class Ejecutivos implements Deposito, Transferencia {

    public Ejecutivos() {
    }

    @Override
    public void hacerDeposito() {
        System.out.println("Relizando depósito.");
    }

    @Override
    public void transferir() {
        System.out.println("Realizando tranferencia.");

    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La transacción " +tipoTransaccion +" ha sido realizada.");

    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción " +tipoTransaccion +" ha sido fallida.");

    }

    //Ejecutivos: Realizan Depósitos y Transferencias.
}
