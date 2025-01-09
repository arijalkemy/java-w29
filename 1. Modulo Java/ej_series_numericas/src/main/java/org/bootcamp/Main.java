package org.bootcamp;

public class Main {
    public static void main(String[] args) {

        SerieNumericaInteger serieNumericaInteger = new SerieNumericaInteger(2);
        System.out.println(serieNumericaInteger.siguienteValor());
        System.out.println(serieNumericaInteger.siguienteValor());
        serieNumericaInteger.reiniciarSerie();
        System.out.println(serieNumericaInteger.siguienteValor());

        System.out.println("------------------------------------");

        SerieNumericaDouble serieNumericaDouble = new SerieNumericaDouble(2.5);
        serieNumericaDouble.establecerValorInicial(10);
        System.out.println(serieNumericaDouble.siguienteValor());
        System.out.println(serieNumericaDouble.siguienteValor());
        System.out.println(serieNumericaDouble.siguienteValor());
    }
}