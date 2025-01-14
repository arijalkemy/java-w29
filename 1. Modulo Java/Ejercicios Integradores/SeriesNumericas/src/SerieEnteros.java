public class SerieEnteros extends SeriePrototipo<Integer> {
    public SerieEnteros(Integer valorInicial, Integer incremento) {
        super(valorInicial, incremento);
    }

    @Override
    public Integer sumar(Integer numero1, Integer numero2) {
        return numero1 + numero2;
    }
}