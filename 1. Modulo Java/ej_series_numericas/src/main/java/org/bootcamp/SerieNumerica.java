package org.bootcamp;

public abstract class SerieNumerica {

    private Number valorInicial = 0;
    private Number valorActual = 0;
    private Number razon;

    public void establecerValorInicial(Number valorInicial) {
        this.valorInicial = valorInicial;
        this.valorActual = valorInicial;
    }

    public abstract Number siguienteValor();

    public void reiniciarSerie(){
        valorActual = valorInicial;
    }

    public SerieNumerica(Number razon) {
        this.razon = razon;
    }

    public Number getValorActual() {
        return valorActual;
    }

    public void setValorActual(Number valorActual) {
        this.valorActual = valorActual;
    }

    public Number getRazon() {
        return razon;
    }
}
