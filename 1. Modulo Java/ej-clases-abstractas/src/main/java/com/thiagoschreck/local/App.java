package com.thiagoschreck.local;

import com.thiagoschreck.local.series_numericas.Incrementador;
import com.thiagoschreck.local.series_numericas.Intcrementador;
import com.thiagoschreck.local.series_numericas.Stringcrementador;

public class App {
    public static void main(String[] args) {
        Incrementador intcrementador = new Intcrementador(1);
        Incrementador stringcrementador = new Stringcrementador("5");

        System.out.println("Intcrementador: " + intcrementador.incrementar());
        System.out.println("Intcrementador: " + intcrementador.incrementar());
        System.out.println("Intcrementador: " + intcrementador.incrementar());

        intcrementador.setValor(6);

        System.out.println("Intcrementador: " + intcrementador.incrementar());
        System.out.println("Intcrementador: " + intcrementador.incrementar());
        System.out.println("Intcrementador: " + intcrementador.incrementar());

        System.out.println("Stringcrementador: " + stringcrementador.incrementar());
        System.out.println("Stringcrementador: " + stringcrementador.incrementar());
        System.out.println("Stringcrementador: " + stringcrementador.incrementar());

        stringcrementador.setValor(6);

        System.out.println("Stringcrementador: " + stringcrementador.incrementar());
        System.out.println("Stringcrementador: " + stringcrementador.incrementar());
        System.out.println("Stringcrementador: " + stringcrementador.incrementar());
    }
}
