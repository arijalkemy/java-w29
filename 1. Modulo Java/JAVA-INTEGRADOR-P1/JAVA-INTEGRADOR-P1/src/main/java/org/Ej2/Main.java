package org.Ej2;

public class Main {
    public static void main(String[] args) {
        // Serie de enteros con incremento de 2
        SerieEnteros serieDeDos = new SerieEnteros(2);
        System.out.println("Serie de 2:");
        System.out.println(serieDeDos.siguienteValor()); // 2
        System.out.println(serieDeDos.siguienteValor()); // 4
        System.out.println(serieDeDos.siguienteValor()); // 6
        serieDeDos.establecerValorInicial(1);
        System.out.println(serieDeDos.siguienteValor()); // 3
        System.out.println(serieDeDos.siguienteValor()); // 5
        serieDeDos.reiniciar();
        System.out.println(serieDeDos.siguienteValor()); // 2

        // Serie de decimales con incremento de 0.5
        SerieDecimales serieDecimal = new SerieDecimales(0.5);
        System.out.println("\nSerie de 0.5:");
        System.out.println(serieDecimal.siguienteValor()); // 0.5
        System.out.println(serieDecimal.siguienteValor()); // 1.0
        System.out.println(serieDecimal.siguienteValor()); // 1.5
        serieDecimal.establecerValorInicial(1.0);
        System.out.println(serieDecimal.siguienteValor()); // 1.5
        System.out.println(serieDecimal.siguienteValor()); // 2.0
    }
}
