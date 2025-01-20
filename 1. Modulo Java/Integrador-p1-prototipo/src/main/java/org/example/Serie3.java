package org.example;

public class Serie3 extends Prototipo<Integer>{
    @Override
    public void reiniciar() {
        super.reiniciar();
    }

    @Override
    public Integer getValorSiguiente() {
        super.setValorActual(getValorActual()+3);
        return getValorActual();
    }
}
