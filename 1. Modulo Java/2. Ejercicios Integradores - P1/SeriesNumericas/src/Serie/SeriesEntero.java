package Serie;

public class SeriesEntero extends Series<Integer> {

    @Override
    public Integer siguiente() {
        this.valorActual++;
        return this.valorActual;
    }
}
