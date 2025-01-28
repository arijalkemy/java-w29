package org.example;

public class Main {
    public static void main(String[] args) {
       
        SerieDe2 serie2 = new SerieDe2();

        System.out.println("Serie de 2:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Valor " + (i + 1) + ": " + serie2.siguienteValor());
        }

        serie2.reiniciar();
        System.out.println("Serie reiniciada:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Valor " + (i + 1) + ": " + serie2.siguienteValor());
        }


        SerieDe1 serie1 = new SerieDe1();

        System.out.println("\nSerie iniciando en 1:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Valor " + (i + 1) + ": " + serie1.siguienteValor());
        }

        serie1.establecerValorInicial(1);
        System.out.println("Valor inicial cambiado a 1:");
        for (int i = 0; i < 4; i++) {
            System.out.println("Valor " + (i + 1) + ": " + serie1.siguienteValor());
        }
    }
}