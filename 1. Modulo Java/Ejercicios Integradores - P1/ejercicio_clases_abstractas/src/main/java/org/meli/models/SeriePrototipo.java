package org.meli.models;

public abstract class SeriePrototipo<T extends Number> {
    protected T valorActual;
    protected T incremento;

    public SeriePrototipo(T valorInicial, T incremento) {
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }

    public abstract T valorSiguiente();

    public abstract void reiniciar(T valorInicial);

    public void establecerValorInicial(T valorInicial) {
        this.valorActual = valorInicial;
    }
}

