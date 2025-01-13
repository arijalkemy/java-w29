public class Reserva {
    enum Tipo {
        HOTEL, COMIDA, BOLETO, TRANSPORTE
    }

    private final Tipo tipo;
    private double precio;

    public Reserva(Tipo tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void aplicarDescuento(double porcentaje){
        this.precio -= this.precio * porcentaje / 100;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }

}
