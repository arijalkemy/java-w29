package clases;

public class SerieProgresivaDos extends Prototipo {

    public SerieProgresivaDos() {
        super();
        establecerValorInicialSerie(0);
    }

    @Override
    public void establecerValorInicialSerie(Number valorInicial) {
        this.valorActual = valorInicial;
    }

}
