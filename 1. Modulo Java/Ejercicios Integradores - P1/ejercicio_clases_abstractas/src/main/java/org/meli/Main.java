package org.meli;

import org.meli.models.SerieDecimales;
import org.meli.models.SerieEnteros;

public class Main {
    public static void main(String[] args) {

        SerieEnteros serieEnteros = new SerieEnteros(2, 2);

        System.out.println("Serie de enteros (incremento de 2):");
        System.out.println(serieEnteros.valorSiguiente());
        System.out.println(serieEnteros.valorSiguiente());
        System.out.println(serieEnteros.valorSiguiente());

        serieEnteros.establecerValorInicial(1);

        System.out.println("Serie reiniciada con valor inicial 1:");
        System.out.println(serieEnteros.valorSiguiente());
        System.out.println(serieEnteros.valorSiguiente());

        SerieDecimales serieDecimales = new SerieDecimales(1.5, 1.5);

        System.out.println("\nSerie de decimales (incremento de 1.5):");
        System.out.println(serieDecimales.valorSiguiente());
        System.out.println(serieDecimales.valorSiguiente());
        System.out.println(serieDecimales.valorSiguiente());

        serieDecimales.reiniciar(0.5);

        System.out.println("Serie reiniciada con valor inicial 0.5:");
        System.out.println(serieDecimales.valorSiguiente());
        System.out.println(serieDecimales.valorSiguiente());
    }
}