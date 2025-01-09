package clases;

public abstract class Prototipo<T extends Number> {

    protected T valorInicial;
    protected T incremento;
    protected T valorActual;

    public Prototipo(T incremento) {
        this.incremento = incremento;
    }

    public abstract T getSiguienteValor();

    public void setValorInicial(T valorIncial) {
        this.valorInicial = valorIncial;
        this.valorActual = valorIncial;
    }

    public void reiniciarValores() {
        this.valorActual = this.valorInicial;
    }
}
