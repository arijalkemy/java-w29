package org.example;

public class Serie2 extends Prototipo{
    public Serie2() {
        reiniciar();
    }

    @Override
    public Number siguiente() {
        Number valor= (this.getValorinicial()).doubleValue() + 2;
        this.setValorinicial(valor);
        return this.getValorinicial();
    }

    @Override
    public void reiniciar() {
        this.setValorinicial(0);
    }
}
