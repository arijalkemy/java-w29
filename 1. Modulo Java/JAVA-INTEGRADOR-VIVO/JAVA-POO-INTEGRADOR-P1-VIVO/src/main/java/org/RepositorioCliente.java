package org;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// Clase RepositorioCliente
class RepositorioCliente {
    private Map<String, List<Localizador>> datos;

    public RepositorioCliente() {
        this.datos = new HashMap<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        String clienteId = localizador.getCliente().getId();
        datos.putIfAbsent(clienteId, new ArrayList<>());
        datos.get(clienteId).add(localizador);
    }

    public List<Localizador> obtenerLocalizadores(String clienteId) {
        return datos.getOrDefault(clienteId, new ArrayList<>());
    }

    public int contarLocalizadoresVendidos() {
        return datos.values().stream().mapToInt(List::size).sum();
    }

    // Cantidad total de reservas
    public int contarReservasTotales() {
        return datos.values().stream()
                .flatMap(List::stream)
                .mapToInt(l -> l.getReservas().size())
                .sum();
    }

    // Diccionario de reservas por tipo
    public Map<String, Long> reservasPorTipo() {
        return datos.values().stream()
                .flatMap(List::stream)
                .flatMap(l -> l.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipo, Collectors.counting()));
    }

    // Total de ventas
    public double calcularTotalVentas() {
        return datos.values().stream()
                .flatMap(List::stream)
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    // Promedio de ventas
    public double calcularPromedioVentas() {
        long totalLocalizadores = contarLocalizadoresVendidos();
        if (totalLocalizadores == 0) return 0;
        return calcularTotalVentas() / totalLocalizadores;
    }

}
