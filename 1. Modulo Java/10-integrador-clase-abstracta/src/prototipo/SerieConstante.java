package prototipo;

public class SerieConstante extends Serie<Integer>{

    private final Integer incremento;

    public SerieConstante(Integer valorInicial, Integer incremento) {
        super(valorInicial);
        this.incremento = incremento;
    }

    @Override
    public Integer devolverSiguienteValor() {
        return super.valorActual += this.incremento;
    }
}
