package org.example.clases;

import org.example.interfaces.ConsultaSaldo;
import org.example.interfaces.RetiroEfectivo;

//Cobradores: Realizan retiro de efectivo y consulta de saldos.
public class Cobradores implements RetiroEfectivo, ConsultaSaldo {
    public Cobradores() {
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Relizando consulta de saldo.");

    }

    @Override
    public void retirarEfectivo() {
        System.out.println("Relizando retiro de efectivo.");
    }

    @Override
    public void transaccionOk(String tipoTransaccion) {
        System.out.println("La transacción " +tipoTransaccion +" ha sido realizada.");

    }

    @Override
    public void transaccionNoOk(String tipoTransaccion) {
        System.out.println("La transacción " +tipoTransaccion +" ha sido fallida.");

    }
}
