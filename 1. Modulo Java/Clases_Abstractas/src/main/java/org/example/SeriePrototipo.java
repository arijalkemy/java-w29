package org.example;

public abstract class SeriePrototipo<T extends Number> {
    private T valorInicial; // Valor inicial
    private int incremento; // Incremento para la serie
    private int contador; // Contador para el número de veces que se ha llamado


    public SeriePrototipo(T valorInicial, int incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.contador = 0; // Contador inicializado a 0
    }


    public T siguienteValor() {
        contador++;
        return calcularValor();
    }


    public void reiniciar() {
        contador = 0;
    }


    public void establecerValorInicial(T nuevoValor) {
        this.valorInicial = nuevoValor;
        this.contador = 0; // Reiniciar el contador al cambiar el valor inicial
    }


    protected abstract T calcularValor();
}
