package clases;

public class SerieProgresivaTres extends Prototipo {

    public SerieProgresivaTres() {
        super();
        establecerValorInicialSerie(0);
    }

    @Override
    public void establecerValorInicialSerie(Number valorInicial) {
        this.valorActual = valorInicial;
    }

}
