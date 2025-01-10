package Serie;

public class SeriesDouble extends Series<Double> {

    @Override
    public Double siguiente() {
        this.valorActual++;
        return this.valorActual;
    }
}
