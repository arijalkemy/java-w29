public class SerieFlotantes extends SeriePrototipo<Double> {
    public SerieFlotantes(Double valorInicial, Double incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Double sumar(Double numero1, Double numero2) {
        return numero1 + numero2;
    }
}