package org.Ej2;

// Clase prototipo
public abstract class SerieProgresiva<T extends Number> {
    protected T valorActual;
    protected T incremento;

    // Constructor
    public SerieProgresiva(T incremento) {
        this.incremento = incremento;
        this.valorActual = incremento;
    }

    // Método para devolver el siguiente valor de la serie
    public T siguienteValor() {
        T valorRetornado = valorActual;
        valorActual = sumar(valorActual, incremento);
        return valorRetornado;
    }

    // Método abstracto para la suma (adaptado para cualquier tipo numérico)
    protected abstract T sumar(T a, T b);

    // Método para reiniciar la serie
    public void reiniciar() {
        this.valorActual = incremento;
    }

    // Método para establecer un valor inicial
    public void establecerValorInicial(T valorInicial) {
        this.valorActual = valorInicial;
    }
}


