package prototipo;

public class SerieMultiplicativa extends Serie<Integer>{
    private final Integer factor;

    public SerieMultiplicativa(Integer valorInicial, Integer factor) {
        super(valorInicial);
        this.factor = factor;
    }

    @Override
    public Integer devolverSiguienteValor() {
        return super.valorActual *= factor;
    }
}
