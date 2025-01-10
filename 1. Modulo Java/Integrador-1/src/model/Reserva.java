package model;

public class Reserva {
    private String tipo; // Puede ser "hotel", "comida", "boleto", "transporte"
    private double total;

    public Reserva(String tipo, double total) {
        this.tipo = tipo;
        this.total = total;
    }

    public String getTipo() {
        return tipo;
    }

    public double getTotal() {
        return total;
    }

    @Override
    public String toString() {
        return "Reserva{" +
                "tipo='" + tipo + '\'' +
                ", total=" + total +
                '}';
    }
}