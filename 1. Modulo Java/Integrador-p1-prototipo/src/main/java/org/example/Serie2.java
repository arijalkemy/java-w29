package org.example;

public class Serie2 extends Prototipo<Integer>{
    @Override
    public Integer getValorSiguiente() {
        super.setValorActual(getValorActual()+2);
        return getValorActual();
    }

}
