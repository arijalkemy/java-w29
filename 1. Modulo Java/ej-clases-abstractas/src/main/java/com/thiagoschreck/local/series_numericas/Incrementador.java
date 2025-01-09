package com.thiagoschreck.local.series_numericas;

public abstract class Incrementador {
    private final int incremento;
    private int valor = 0;

    public Incrementador(int valorSerie) {
        this.incremento = valorSerie;
    }

    public int incrementar() {
        valor += incremento;
        return valor;
    }

    public void reiniciar() {
        valor = 0;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }
}