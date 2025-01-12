package model;

public class Comida extends Reserva {

    public Comida(Double precio) {
        super(TipoReserva.COMIDA.getDescripcion(), precio);
    }
}
