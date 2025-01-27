package com.example;

public class SerieInteger extends Prototipo<Integer> {

    public SerieInteger(Integer puntoInicial, Integer incremento) {
        super(puntoInicial, incremento);
    }

    @Override
    public Integer obtenerSiguiente() {
        return this.puntoActual += this.incremento;
    }

}
