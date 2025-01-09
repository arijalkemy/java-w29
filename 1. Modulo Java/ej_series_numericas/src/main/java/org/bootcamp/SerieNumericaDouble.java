package org.bootcamp;

public class SerieNumericaDouble extends SerieNumerica {
    public SerieNumericaDouble(Double razon) {
        super(razon);
    }

    @Override
    public Double siguienteValor() {
        Double siguienteValor = getValorActual().doubleValue() + getRazon().doubleValue();
        setValorActual(siguienteValor);
        return siguienteValor;
    }
}
