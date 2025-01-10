package org.meli.models;

public class SerieEnteros extends SeriePrototipo<Integer> {

    public SerieEnteros(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer valorSiguiente() {
        int resultado = valorActual;
        valorActual += incremento;
        return resultado;
    }

    @Override
    public void reiniciar(Integer valorInicial) {
        this.valorActual = valorInicial;
    }
}

