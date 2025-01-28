package org.example;


public class SerieDe1 extends SeriePrototipo<Integer> {
    public SerieDe1() {
        super(1, 2); // Para establecer el valor inicial a 1, el incremento es 2
    }

    @Override
    protected Integer calcularValor() {
        return (int) (1 + (getContador() * 2));
    }


    private int getContador() {
        return super.siguienteValor().intValue();
    }
}
