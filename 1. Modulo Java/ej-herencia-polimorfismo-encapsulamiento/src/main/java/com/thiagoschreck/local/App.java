package com.thiagoschreck.local;

import com.thiagoschreck.local.distribuidora.Distribuidora;

public class App {
    public static void main(String[] args) {
//        PracticaExcepciones practicaExcepciones = new PracticaExcepciones();
//        practicaExcepciones.calcularCoeficienteAB();

        Distribuidora distribuidora = new Distribuidora();
        distribuidora.vender();
    }
}
