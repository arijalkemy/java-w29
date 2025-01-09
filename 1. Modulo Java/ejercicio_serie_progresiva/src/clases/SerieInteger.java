package clases;

public class SerieInteger extends Prototipo<Integer> {

    public SerieInteger(Integer incremento) {
        super(incremento);
    }

    @Override
    public Integer getSiguienteValor() {
        this.valorActual += this.incremento;
        return valorActual;
    }
}
