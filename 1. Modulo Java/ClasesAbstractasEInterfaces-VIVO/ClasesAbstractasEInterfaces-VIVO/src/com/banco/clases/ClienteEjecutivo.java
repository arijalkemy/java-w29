package com.banco.clases;

import com.banco.Interfaces.*;

public class ClienteEjecutivo implements ConsultaDeSaldo, PagoDeServicios, RetiroDeEfectivo, Deposito, Transferencia {
    private static final boolean consultaDeSaldo = false;
    private static final boolean pagoDeServicios = false;
    private static final boolean retiroDeEfectivo = false;
    private static final boolean deposito = true;
    private static final boolean transferencia = true;


    @Override
    public void consultarSaldo() {
        if (consultaDeSaldo == true){
            System.out.println("Consultando saldo...");
            transaccionOk("consulta de saldo");
        }
        else {
            System.out.println("Consultando saldo...");
            transaccionNoOk("consulta de saldo");
        }
    }

    @Override
    public void pagarServicios(String tipoServicio) {
        if (pagoDeServicios == true) {
            System.out.println("Pagando servicio: " + tipoServicio);
            transaccionOk("pagando servicio");
        }
        else {
            System.out.println("Pagando servicio: " + tipoServicio);
            transaccionNoOk("pagando servicio");
        }
    }

    @Override
    public void retiroDeEfectivo(Double monto) {
        if (retiroDeEfectivo == true) {
            System.out.println("Intentando retirar: " + monto);
            transaccionOk("retiro de efectivo");
        }
        else {
            System.out.println("Intentando retirar: " + monto);
            transaccionNoOk("retiro de efectivo");
        }
    }

    @Override
    public void hacerDeposito() {
        if (deposito == true) {
            System.out.println("Intentando depositar" );
            transaccionOk("deposito");
        }
        else {
            System.out.println("Intentando depositar" );
            transaccionNoOk("deposito");
        }
    }

    @Override
    public void hacerTransferencia() {
        if (transferencia == true) {
            System.out.println("Intentando transferir" );
            transaccionOk("transferencia");
        }
        else {
            System.out.println("Intentando transferir" );
            transaccionNoOk("transferencia");
        }
    }

    @Override
    public void transaccionOk(String transaccion) {
        System.out.println("Transaccion ok: " + transaccion);
    }

    @Override
    public void transaccionNoOk(String transaccion) {
        System.out.println("Transaccion no ok: " + transaccion);
    }
}
