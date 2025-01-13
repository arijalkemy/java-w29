import java.util.ArrayList;
import java.util.List;

public abstract class SerieNumerica <T extends Number> {
    private T valorInicial;
    private Double valorInicialDouble;
    private boolean valorInicialEsUno;
    private T valorActual;

    public SerieNumerica(T valorInicial) {
        this.valorInicial = valorInicial;
        this.valorInicialDouble = valorInicial.doubleValue();
        this.valorInicialEsUno = valorInicialDouble/1 == 1;
        this.valorActual = configurarValorActual();
    }

    public Integer configurarValorActualDefault() {
        return valorInicialEsUno ? 1 : 0;
    }

    public Double siguienteValorDefault() {
        Double valorActualDouble = valorActual.doubleValue();
        return valorInicialEsUno ? valorActualDouble + 2 : valorActualDouble + valorInicialDouble;
    };

    public abstract T configurarValorActual();
    public abstract T siguienteValor();

    public void reiniciarSerie() {
        valorActual = valorInicial;
    }

    public void mostrarSerie(int cantIteraciones) {
        System.out.printf("%s - Valor inicial = " + valorInicial + "\n", getClass().getSimpleName());
        for (int i = 0; i < cantIteraciones; i++) {
            System.out.println("\t - " + siguienteValor());
        }
        System.out.println();
    }

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