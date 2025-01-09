public class Reserva {
    private TipoReserva tipoReserva;
    //grupo 3
    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoPaquete) {
        this.tipoReserva = tipoPaquete;
    }

    public Reserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public enum TipoReserva{
        COMIDA,
        BOLETO,
        TRANSPORTE,
        HOTEL
    }

    @Override
    public String toString() {
        return ""+tipoReserva;
    }
}
