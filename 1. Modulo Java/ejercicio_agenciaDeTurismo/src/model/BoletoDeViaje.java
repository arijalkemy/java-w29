package model;

public class BoletoDeViaje extends Reserva {

    public BoletoDeViaje(Double precio) {
        super(TipoReserva.BOLETO_DE_VIAJE.getDescripcion(), precio);
    }
}
