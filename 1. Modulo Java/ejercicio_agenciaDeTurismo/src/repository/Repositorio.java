package repository;

import model.Cliente;
import model.Localizador;

import java.util.*;
import java.util.Map;
import java.util.stream.Collectors;

public class Repositorio {  private Map<Integer, List<Localizador>> clientes = new HashMap<>();

    public void agregarLocalizador(Cliente cliente, Localizador localizador) {

        List<Localizador> localizadores = clientes.getOrDefault(cliente.getDni(), new ArrayList<>());
        localizadores.add(localizador);
        clientes.put(cliente.getDni(), localizadores);
    }

    public List<Localizador> obtenerCantidadLocalizadoresCliente(Cliente cliente) {
        return clientes.getOrDefault(cliente.getDni(), Collections.emptyList());
    }

    public int obtenerTotalLocalizadores() {
        return clientes.values().stream()
            .mapToInt(List::size)
            .sum();

    }
    public List<Localizador> obtenerTodosLosLocalizadores() {
        return clientes.values().stream()
                .flatMap(List::stream)
                .toList();
    }

    public Integer obtenerTotalReservas() {
        return clientes.values().stream()
                .flatMap(List::stream)
                .mapToInt(Localizador::totalDeReservas)
                .sum();
    }

    public Map<String, Integer> obtenerResumenReservas() {
        return clientes.values().stream()
                .flatMap(List::stream)
                .map(Localizador::getCantidadReservas)
                .flatMap(reservas -> reservas.entrySet().stream())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        Integer::sum
                ));
    }
}





