package ejercicioIntegrador;

class Reserva {
    enum Tipo { HOTEL, COMIDA, BOLETOS, TRANSPORTE }

    private Tipo tipo;
    private double costo;

    public Reserva(Tipo tipo, double costo) {
        this.tipo = tipo;
        this.costo = costo;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public double getCosto() {
        return costo;
    }
}