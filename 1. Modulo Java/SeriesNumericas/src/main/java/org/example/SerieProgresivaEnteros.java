package org.example;

public class SerieProgresivaEnteros extends SerieProgresiva<Integer> {


    public SerieProgresivaEnteros(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    protected Integer sum(Integer a, Integer b) {
        return a + b;
    }
}
