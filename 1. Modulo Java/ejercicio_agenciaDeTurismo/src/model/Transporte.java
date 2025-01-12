package model;

public class Transporte extends Reserva {

    public Transporte(Double precio) {
        super(TipoReserva.TRANSPORTE.getDescripcion(), precio);
    }
}
