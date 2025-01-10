package org.example.entidades;

public class Prototipo {
    private static Integer numero = 0;
    private static Integer incremento = 1;

    public static Integer proximoNumSerie() {
        return Prototipo.numero+=Prototipo.incremento;
    }

    public static void reiniciarSerie() {
        Prototipo.numero = 0;
    }

    public static void valorInicialSerie(Number numero) {
        Prototipo.numero = (Integer) numero;
    }

    public static void setIncremento(Integer incremento) {
        Prototipo.incremento = incremento;
    }
}
