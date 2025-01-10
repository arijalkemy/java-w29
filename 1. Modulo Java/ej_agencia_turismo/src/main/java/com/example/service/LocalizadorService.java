package com.example.service;

import com.example.model.Cliente;
import com.example.model.Localizador;
import com.example.model.Reserva;
import com.example.model.TipoReserva;
import com.example.repository.LocalizadorRepositoryImpl;

import java.util.*;
import java.util.stream.Collectors;

public class LocalizadorService {

    private final LocalizadorRepositoryImpl repository;

    public LocalizadorService(LocalizadorRepositoryImpl repository) {
        this.repository = repository;
    }

    public Localizador crearLocalizador(Cliente cliente, List<Reserva> reservas) {
        List<Localizador> localizadores = repository.getLocalizadoresByCliente(cliente.getId());
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

    public long getCantidadLocalizadoresVendidos() {
        return repository.getAll().size();
    }

    private List<Reserva> getReservas() {
        return repository.getAll().stream()
                .flatMap(localizador -> localizador.getReservas().stream()).toList();
    }

    public long getTotalReservas() {
        return getReservas().size();
    }

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

    public double getTotalVentas() {
        return repository.getAll().stream().mapToDouble(Localizador::getTotal).sum();
    }

    public double getPromedioVentas() {
        return repository.getAll().stream().mapToDouble(Localizador::getTotal).average().orElse(0.0);
    }

    private boolean esPaqueteCompleto(List<Reserva> reservas) {
        Set<TipoReserva> tiposReserva = reservas.stream().map(Reserva::getTipo).collect(Collectors.toSet());
        final List<TipoReserva> tipos = Arrays.asList(TipoReserva.values());
        return tiposReserva.containsAll(tipos);
    }

}
