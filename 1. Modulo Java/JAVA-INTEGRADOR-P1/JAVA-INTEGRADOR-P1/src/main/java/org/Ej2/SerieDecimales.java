package org.Ej2;

// Clase para series de números decimales (Double)
class SerieDecimales extends SerieProgresiva<Double> {
    public SerieDecimales(Double incremento) {
        super(incremento);
    }

    @Override
    protected Double sumar(Double a, Double b) {
        return a + b;
    }
}