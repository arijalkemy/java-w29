package clases;

public class SerieDouble extends Prototipo<Double> {

    public SerieDouble(Double incremento) {
        super(incremento);
    }

    @Override
    public Double getSiguienteValor() {
        this.valorActual += this.incremento;
        return valorActual;
    }
}