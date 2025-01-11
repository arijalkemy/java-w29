package com.banco.clases;

public class Main {
    public static void main(String[] args) {
        ClienteBasic basic = new ClienteBasic();
        ClienteEjecutivo ejecutivo = new ClienteEjecutivo();
        ClienteCobrador cobrador = new ClienteCobrador();

        System.out.println("Basico");
        basic.pagarServicios("luz");
        basic.consultarSaldo();
        basic.retiroDeEfectivo(150.000);
        basic.hacerTransferencia();
        basic.hacerDeposito();
        System.out.println("--------");
        System.out.println("Ejecutivo");
        ejecutivo.pagarServicios("gas");
        ejecutivo.consultarSaldo();
        ejecutivo.retiroDeEfectivo(1000.000);
        ejecutivo.hacerTransferencia();
        ejecutivo.hacerDeposito();
        System.out.println("--------");
        System.out.println("Cobrador");
        cobrador.pagarServicios("agua");
        cobrador.consultarSaldo();
        cobrador.retiroDeEfectivo(500.000);
        cobrador.hacerTransferencia();
        cobrador.hacerDeposito();

    }

}
