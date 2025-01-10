package org.meli.models;

public class SerieDecimales extends SeriePrototipo<Double> {

    public SerieDecimales(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Double valorSiguiente() {
        double resultado = valorActual;
        valorActual += incremento;
        return resultado;
    }

    @Override
    public void reiniciar(Double valorInicial) {
        this.valorActual = valorInicial;
    }
}
