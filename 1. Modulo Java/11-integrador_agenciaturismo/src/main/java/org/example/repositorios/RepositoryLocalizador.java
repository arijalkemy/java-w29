package org.example.repositorios;

import org.example.clases.Cliente;
import org.example.clases.Localizador;
import org.example.clases.Reserva;

import java.util.List;

public interface RepositoryLocalizador {
    public void agregarLocalizador(Localizador localizador);
    public List<Localizador> obtenerLocalizadoresCliente(Cliente cliente);
    public Double calcularPrecio(Cliente cliente, List<Reserva> reservas);
    public Integer localizadoresVendidos();
    public Integer reservasVendidas();
}
