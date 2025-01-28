package com.example.services;

import com.example.entities.Cliente;
import com.example.entities.Localizador;
import com.example.entities.Reserva;
import com.example.enums.TipoReserva;
import com.example.repositories.LocalizadorRepository;
import lombok.RequiredArgsConstructor;

import java.util.*;
import java.util.stream.Collectors;

@RequiredArgsConstructor
public class LocalizadorServiceImpl implements LocalizadorService {

    private final LocalizadorRepository repository;

    @Override
    public Localizador crearLocalizador(Cliente cliente, List<Reserva> reservas) {
        List<Localizador> localizadores = repository.findLocalizadoresByCliente(cliente.getId());
        Localizador localizador = new Localizador(cliente, reservas);

        // Aplicar descuentos
        if (localizadores.size() >= 2) {
            localizador.aplicarDescuento(0.05);
        }
        if (esPaqueteCompleto(reservas)) {
            localizador.aplicarDescuento(0.10);
        }
        if (localizador.getCantidadDe(TipoReserva.HOTEL) >= 2 || localizador.getCantidadDe(TipoReserva.BOLETO) >= 2) {
            localizador.aplicarDescuento(0.05);
        }

        repository.addLocalizador(localizador);

        return localizador;
    }

    @Override
    public long getCantidadLocalizadoresVendidos() {
        return repository.findAll().size();
    }

    @Override
    public long getTotalReservas() {
        return getReservas().size();
    }

    @Override
    public Map<TipoReserva, List<Reserva>> getReservasByTipo() {
        Map<TipoReserva, List<Reserva>> diccionario = new HashMap<>();

        List<TipoReserva> tipos = Arrays.asList(TipoReserva.values());
        tipos.forEach(t -> diccionario.put(t, new ArrayList<>()));

        List<Reserva> reservas = getReservas();

        reservas.forEach(r -> {
            TipoReserva tipo = r.getTipo();
            diccionario.get(tipo).add(r);
        });

        return diccionario;
    }

    @Override
    public double getTotalVentas() {
        return repository.findAll().stream().mapToDouble(Localizador::getTotal).sum();
    }

    @Override
    public double getPromedioVentas() {
        return repository.findAll().stream().mapToDouble(Localizador::getTotal).average().orElse(0.0);
    }

    private boolean esPaqueteCompleto(List<Reserva> reservas) {
        Set<TipoReserva> tiposReserva = reservas.stream().map(Reserva::getTipo).collect(Collectors.toSet());
        final List<TipoReserva> tipos = Arrays.asList(TipoReserva.values());
        return tiposReserva.containsAll(tipos);
    }

    private List<Reserva> getReservas() {
        return repository.findAll().stream()
                .flatMap(localizador -> localizador.getReservas().stream()).toList();
    }
}
