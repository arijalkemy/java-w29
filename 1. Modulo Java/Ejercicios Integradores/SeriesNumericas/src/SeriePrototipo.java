public abstract class SeriePrototipo<T extends Number> {
    private T valorActual;
    private T incremento;

    public SeriePrototipo(T valorInicial, T incremento) {
        this.valorActual = valorInicial;
        this.incremento = incremento;
    }

    public T siguienteValor() {
        valorActual = sumar(valorActual, incremento);
        return valorActual;
    }

    public void reiniciar(T valorInicial) {
        this.valorActual = valorInicial;
    }

    public void establecerValorInicial(T valorInicial) {
        this.valorActual = valorInicial;
    }

    public abstract T sumar(T numero1, T numero2);
}
