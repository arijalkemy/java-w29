package model;

public class Hotel extends Reserva {
    public Hotel(Double precio) {
        super(TipoReserva.HOTEL.getDescripcion(), precio);
    }
}
