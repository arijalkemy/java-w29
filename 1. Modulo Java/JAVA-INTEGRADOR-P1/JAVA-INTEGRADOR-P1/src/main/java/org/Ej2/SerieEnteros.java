package org.Ej2;


class SerieEnteros extends SerieProgresiva<Integer> {
    public SerieEnteros(Integer incremento) {
        super(incremento);
    }

    @Override
    protected Integer sumar(Integer a, Integer b) {
        return a + b;
    }
}
