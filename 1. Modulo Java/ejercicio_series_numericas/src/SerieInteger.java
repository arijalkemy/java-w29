public class SerieInteger extends SerieNumerica<Integer> {

    public SerieInteger(Integer valorInicial) {
        super(valorInicial);
    }

    @Override
    public Integer configurarValorActual() {
        return configurarValorActualDefault();
    }

    @Override
    public Integer siguienteValor() {
        setValorActual(siguienteValorDefault().intValue());
        return getValorActual();
    }
}
