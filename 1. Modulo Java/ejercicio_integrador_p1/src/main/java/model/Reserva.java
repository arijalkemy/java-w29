package model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Reserva {
    private TipoReserva tipo;
    private Double valor;

    public Reserva(TipoReserva tipoReserva, double valor) {
        this.tipo = tipoReserva;
        this.valor = valor;
    }
}
