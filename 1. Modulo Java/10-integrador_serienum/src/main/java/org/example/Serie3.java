package org.example;

public class Serie3 extends Prototipo{
    public Serie3() {
        reiniciar();
    }

    @Override
    public Number siguiente() {
        Number valor = (this.getValorinicial()).doubleValue() + 3;
        this.setValorinicial(valor);
        return this.getValorinicial();
    }

    @Override
    public void reiniciar() {
        this.setValorinicial(0);
    }
}
