package org.example.clases;

import org.example.interfaces.ConsultaSaldo;
import org.example.interfaces.PagoServicio;
import org.example.interfaces.RetiroEfectivo;

//Basic: Realizan consultas de saldo, pagos de servicios y retiro de efectivo.
public class Basic implements ConsultaSaldo, PagoServicio, RetiroEfectivo {
    public Basic() {
    }

    @Override
    public void consultarSaldo() {
        System.out.println("Relizando consulta de saldo.");
    }

    @Override
    public void pagar() {
        System.out.println("Relizando pago.");

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
