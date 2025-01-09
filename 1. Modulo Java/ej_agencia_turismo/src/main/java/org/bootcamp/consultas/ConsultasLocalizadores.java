package org.bootcamp.consultas;

import org.bootcamp.reservas.Reserva;
import org.bootcamp.contenedores.Localizador;
import org.bootcamp.contenedores.RepositorioLocalizador;

import java.util.ArrayList;
import java.util.List;

public class ConsultasLocalizadores {
    private RepositorioLocalizador repositorioLocalizador;

    public ConsultasLocalizadores(RepositorioLocalizador repositorioLocalizador) {
        this.repositorioLocalizador = repositorioLocalizador;
    }

    public int obtenerCantidadLocalizadoresVendidos() {
        return repositorioLocalizador.obtenerTodos().size();
    }

    public int obtenerCantidadTotalReservas() {
        return repositorioLocalizador.obtenerTodos().stream()
                .mapToInt(localizador -> localizador.getReservas().size())
                .sum();
    }

    public List<Reserva>  obtenerReservasPorTipo() {
        List<Reserva> reservas = new ArrayList<>();
        repositorioLocalizador.obtenerTodos().stream().forEach(localizador -> reservas.addAll(localizador.getReservas()));
        reservas.sort((reserva1, reserva2) -> reserva1.getClass().getSimpleName().compareTo(reserva2.getClass().getSimpleName()));
        return reservas;
    }




    public double obtenerTotalVentas() {
        return repositorioLocalizador.obtenerTodos().stream()
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public double obtenerPromedioVentas() {
        List<Localizador> localizadores = repositorioLocalizador.obtenerTodos();
        return localizadores.stream()
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0.0);
    }
}