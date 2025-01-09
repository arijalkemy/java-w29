package com.example.service;

import com.example.model.Cliente;
import com.example.model.Localizador;
import com.example.model.Reserva;
import com.example.model.TipoReserva;
import com.example.repository.LocalizadorRepositoryImpl;

import java.util.*;

public class LocalizadorService {

    private final LocalizadorRepositoryImpl localizadorRepository;

    public LocalizadorService() {
        this.localizadorRepository = new LocalizadorRepositoryImpl();
    }

    private boolean esPaqueteCompleto(List<Reserva> reservas) {
        List<TipoReserva> tipos = reservas.stream().map(Reserva::getTipo).toList();
        final List<TipoReserva> tiposDescuento10 = Arrays.asList(TipoReserva.values());
        return tipos.containsAll(tiposDescuento10);
    }

    private long getCantidadDe(List<Reserva> reservas, TipoReserva filter) {
        return reservas.stream()
                .filter(reserva -> reserva.getTipo().equals(filter))
                .count();
    }

    public Localizador crearLocalizador(Cliente cliente, List<Reserva> reservas) {
        List<Localizador> localizadores = localizadorRepository.getLocalizadoresByCliente(cliente.getId());
        Localizador nuevoLocalizador = new Localizador(cliente, reservas);

        // Aplicar descuentos
        if (localizadores.size() >= 2) {
            nuevoLocalizador.aplicarDescuento(0.05);
        }
        if (esPaqueteCompleto(reservas)) {
            nuevoLocalizador.aplicarDescuento(0.10);
        }
        if (getCantidadDe(reservas, TipoReserva.HOTEL) >= 2 || getCantidadDe(reservas, TipoReserva.BOLETO) >= 2) {
            nuevoLocalizador.aplicarDescuento(0.05);
        }

        // Agregar el localizador al repository
        localizadorRepository.addLocalizador(nuevoLocalizador);

        return nuevoLocalizador;
    }

    public long getCantidadLocalizadoresVendidos() {
        return localizadorRepository.getAll().size();
    }

    private List<Reserva> getReservas() {
        return localizadorRepository.getAll().stream()
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
        return localizadorRepository.getAll().stream().mapToDouble(Localizador::getTotal).sum();
    }

    public double getPromedioVentas() {
        return localizadorRepository.getAll().stream().mapToDouble(Localizador::getTotal).average().orElse(0.0);
    }

}
