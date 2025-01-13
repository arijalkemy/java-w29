public class SerieDouble extends SerieNumerica<Double> {

    public SerieDouble(Double valorInicial) {
        super(valorInicial);
    }

    @Override
    public Double configurarValorActual() {
        return configurarValorActualDefault().doubleValue();
    }

    @Override
    public Double siguienteValor() {
        setValorActual(siguienteValorDefault());
        return getValorActual();
    }
}
