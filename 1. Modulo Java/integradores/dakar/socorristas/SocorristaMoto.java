package com.example.demo.integradores.dakar.socorristas;

import com.example.demo.integradores.dakar.Moto;

public class SocorristaMoto implements Socorrista <Moto>{
    public void socorrer(Moto unaMoto) {
        System.out.println("Socorriendo moto con patente: " + unaMoto.getPatente());
    }
}
