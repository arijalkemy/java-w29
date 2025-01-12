package model;

public enum TipoReserva {
    HOTEL("model.Hotel"),
    COMIDA("model.Comida"),
    BOLETO_DE_VIAJE("Boleto de viaje"),
    TRANSPORTE("model.Transporte");

    private final String tipoReserva;

    TipoReserva(String descripcion) {
        this.tipoReserva = descripcion;
    }

    public String getDescripcion() {
        return tipoReserva;
    }
}
