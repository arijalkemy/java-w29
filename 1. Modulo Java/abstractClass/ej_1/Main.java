package com.example.demo.abstractClass.ej_1;

public class Main {
    public static void main(String[] args) {

        Ejecutivo ejecutivo = new Ejecutivo();
        System.out.println("Cliente Ejecutivo:");
        ejecutivo.realizarDeposito();
        ejecutivo.realizarTransferencia();

        Basic basic = new Basic();
        System.out.println("\nCliente Basic:");
        basic.consultarSaldo();
        basic.realizarRetiro();
        basic.pagarServicios();

        Cobrador cobrador = new Cobrador();
        System.out.println("\nCliente Cobrador:");
        cobrador.consultarSaldo();
        cobrador.realizarRetiro();
    }
}
