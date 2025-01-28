package com.example.entities;

import com.example.enums.TipoReserva;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Reserva {
    private TipoReserva tipo;

    private double precio;
}
