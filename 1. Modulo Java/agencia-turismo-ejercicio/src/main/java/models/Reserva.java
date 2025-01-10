package models;

public class Reserva {
    private TipoReserva tipo;
    private double precio;

    public Reserva(TipoReserva tipo, double precio) {
        this.tipo = tipo;
        this.precio = precio;
    }

    public TipoReserva getTipo() {
        return tipo;
    }

    public void setTipo(TipoReserva tipo) {
        this.tipo = tipo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipo=" + tipo +
                ", precio=" + precio +
                '}';
    }
}
