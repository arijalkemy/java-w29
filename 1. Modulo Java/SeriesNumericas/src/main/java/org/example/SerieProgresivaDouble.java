package org.example;

public class SerieProgresivaDouble extends SerieProgresiva<Double> {
    public SerieProgresivaDouble(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    protected Double sum(Double a, Double b) {
        return a + b;
    }
}
