public class Reserva {

    public enum Tipo {
        HOTEL,
        COMIDA,
        BOLETO,
        TRANSPORTE
    }

    private Tipo tipo;
    private double valor;

    public Reserva(Tipo tipo, double valor) {
        this.tipo = tipo;
        this.valor = valor;
    }

    public Tipo getTipo() {
        return tipo;
    }

}
