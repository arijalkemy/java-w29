package org.example;

import org.example.entidades.Prototipo;

public class Main {
    public static void main(String[] args) {
        Prototipo.setIncremento(3);
        System.out.println(Prototipo.proximoNumSerie());
        System.out.println(Prototipo.proximoNumSerie());
        System.out.println(Prototipo.proximoNumSerie());
        System.out.println(Prototipo.proximoNumSerie());

        Prototipo.reiniciarSerie();
        Prototipo.setIncremento(2);
        System.out.println(Prototipo.proximoNumSerie());
        System.out.println(Prototipo.proximoNumSerie());
        System.out.println(Prototipo.proximoNumSerie());
        System.out.println(Prototipo.proximoNumSerie());
    }
}