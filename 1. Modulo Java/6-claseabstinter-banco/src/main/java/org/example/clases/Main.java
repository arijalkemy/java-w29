package org.example.clases;

public class Main {
    public static void main(String[] args) {

        System.out.println("EJECUTIVO");
        Ejecutivos ejecutivos = new Ejecutivos();
        ejecutivos.hacerDeposito();
        ejecutivos.transferir();
        ejecutivos.transaccionOk("Tranferencia");
        ejecutivos.transaccionNoOk("Depósito");

        System.out.println("BASIC");
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.pagar();
        basic.retirarEfectivo();
        basic.transaccionNoOk("Consulta de saldo");
        basic.transaccionOk("Pagar");
        basic.transaccionOk("Retirar efectivo");

        System.out.println("COBRADORES");
        Cobradores cobradores = new Cobradores();
        cobradores.consultarSaldo();
        cobradores.retirarEfectivo();
        cobradores.transaccionNoOk("Retirar efectivo");
        cobradores.transaccionOk("Consultar saldo");
    }
}