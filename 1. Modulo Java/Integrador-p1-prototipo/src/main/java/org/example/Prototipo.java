package org.example;

public abstract class Prototipo<T extends Number> {

    private T valorActual;
    private T valorInicial;


    public abstract T getValorSiguiente();

    public void setValorInicial(T value) {
        this.valorInicial = value;
    }

    public T getValorActual() {
        return this.valorActual;
    }
    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }
    public void reiniciar(){this.valorActual = this.valorInicial;};
}
