package com.example;

import com.example.clientes.Basic;

public class Main {

    public static void main(String[] args) {
        Basic basic = new Basic(1000);
        basic.consultarSaldo();
        basic.pagarServicio(600);
        basic.consultarSaldo();
        basic.retirarEfectivo(500);
    }

}
