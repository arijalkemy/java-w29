package com.example;

public abstract class Prototipo <T extends Number> {

    public T puntoInicial;

    public T puntoActual;

    public T incremento;

    public void setPuntoInicial(T puntoInicial) {
        this.puntoInicial = puntoInicial;
        this.puntoActual = puntoInicial;
    }

    public void reiniciar() {
        this.puntoActual = puntoInicial;
    }

    public abstract T obtenerSiguiente();

    public Prototipo(T puntoInicial, T incremento) {
        this.puntoInicial = puntoInicial;
        this.puntoActual = puntoInicial;
        this.incremento = incremento;
    }

}
