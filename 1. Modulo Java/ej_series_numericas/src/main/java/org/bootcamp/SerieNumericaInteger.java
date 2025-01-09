package org.bootcamp;

public class SerieNumericaInteger extends SerieNumerica {
    public SerieNumericaInteger(Integer razon) {
        super(razon);
    }

    @Override
    public Integer siguienteValor() {
        Integer siguienteValor = getValorActual().intValue() + getRazon().intValue();
        setValorActual(siguienteValor);
        return siguienteValor;
    }
}
