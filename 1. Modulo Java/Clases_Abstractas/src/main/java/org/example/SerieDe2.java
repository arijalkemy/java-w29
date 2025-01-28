package org.example;


public class SerieDe2 extends SeriePrototipo<Integer> {
    public SerieDe2() {
        super(2, 2); // Inicializamos con el valor 2 y un incremento de 2
    }

    @Override
    protected Integer calcularValor() {
        return (int) (getValorInicial().intValue() + (getContador() * 2));
    }


    private Integer getValorInicial() {
        return (Integer) super.siguienteValor() - (getContador() * 2);
    }

    private int getContador() {
        return super.siguienteValor().intValue();
    }
}
