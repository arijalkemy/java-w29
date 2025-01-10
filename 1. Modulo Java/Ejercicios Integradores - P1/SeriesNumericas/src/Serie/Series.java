package Serie;

public abstract class Series<T extends Number> {
    protected T valorInicial;
    protected T valorActual;

    public abstract T siguiente();

    public void reiniciar() {
        valorActual = valorInicial;
    }

    public void establecer(T valor) {
        valorInicial = valor;
        valorActual = valor;
    }
}
