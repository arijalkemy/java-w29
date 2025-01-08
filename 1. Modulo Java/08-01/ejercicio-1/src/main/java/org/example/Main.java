package org.example;

import org.example.entidades.Basic;
import org.example.entidades.Cobrador;
import org.example.entidades.Ejecutivo;

public class Main {
    public static void main(String[] args) {
        Basic basic = new Basic();
        Cobrador cobrador = new Cobrador();
        Ejecutivo ejecutivo = new Ejecutivo();

        basic.consultarSaldo();
        basic.pagarServicio();
        basic.retirarEfectivo();
        basic.transaccionOk();
        basic.transaccionNoOk();

        cobrador.consultarSaldo();
        cobrador.retirarEfectivo();
        cobrador.transaccionOk();
        cobrador.transaccionNoOk();

        ejecutivo.depositar();
        ejecutivo.transferir();
        ejecutivo.transaccionOk();
        ejecutivo.transaccionNoOk();
    }
}