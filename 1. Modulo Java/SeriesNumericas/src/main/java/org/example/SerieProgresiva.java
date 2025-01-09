package org.example;

public abstract class SerieProgresiva<T extends Number> {
    protected T valorInicial;
    protected T incremento;
    protected T valorAtual;

    public SerieProgresiva(T valorInicial, T incremento) {
        this.valorInicial = valorInicial;
        this.incremento = incremento;
        this.valorAtual = valorInicial;
    }

    public T valorSiguiente(){
        T siguienteValor = valorAtual;
        valorAtual = sum(valorAtual, incremento);
        return siguienteValor;
    };

    public void reiniciarSerie(){
        valorAtual = valorInicial;
    };
    public void establecerValorInicial(T valorInicial){
        this.valorInicial = valorInicial;
        this.valorAtual = valorInicial;
    };

    protected abstract T sum(T a, T b);
}
