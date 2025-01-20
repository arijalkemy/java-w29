package org.example.poo.part2;

public class Main {
    public static void main(String[] args) {

        System.out.println("---Ejecutivo---");
        Ejecutivo ejec = new Ejecutivo();
        ejec.hacerDeposito();
        ejec.hacerTransferencia();
        ejec.transaccionNoOk("Depósito");
        ejec.transaccionOk("Transferencia");

        System.out.println("---Cobrador---");
        Cobrador cobr = new Cobrador();
        cobr.consultarSaldo();
        cobr.retirarEfectivo();
        cobr.transaccionNoOk("Retiro de efectivo");
        cobr.transaccionOk("Retiro de efectivo");

        System.out.println("---Basic---");
        Basic basic = new Basic();
        basic.consultarSaldo();
        basic.retirarEfectivo();
        basic.transaccionNoOk("Retiro de efectivo");
        basic.transaccionOk("Retiro de efectivo");
    }
}