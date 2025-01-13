package com.example.services;

import com.example.entities.Cliente;
import com.example.entities.Localizador;
import com.example.entities.Reserva;
import com.example.enums.TipoReserva;

import java.util.*;

public interface LocalizadorService {

    Localizador crearLocalizador(Cliente cliente, List<Reserva> reservas);

    long getCantidadLocalizadoresVendidos();

    long getTotalReservas();

    Map<TipoReserva, List<Reserva>> getReservasByTipo();

    double getTotalVentas();

    double getPromedioVentas();

}
