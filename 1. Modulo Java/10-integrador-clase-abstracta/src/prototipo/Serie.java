package prototipo;

public abstract class Serie<T extends Number> {
    protected T valorInicial;
    protected T valorActual;

    public Serie(T valorInicial){
        this.valorInicial = valorInicial;
        this.valorActual = this.valorInicial;
    }

    // 1.
    public abstract T devolverSiguienteValor();
    // 2.
    public void reiniciarSerie(){
        this.valorActual = this.valorInicial;
    }
    // 3.
    public void establecerValorInicial(T nuevoValor){
        this.valorInicial = nuevoValor;
        this.valorActual = this.valorInicial;
    }
    //

    public T getValorInicial() {
        return valorInicial;
    }

    public void setValorInicial(T valorInicial) {
        this.valorInicial = valorInicial;
    }

    public T getValorActual() {
        return valorActual;
    }

    public void setValorActual(T valorActual) {
        this.valorActual = valorActual;
    }
}
