package repository;

import db.Db;
import model.Localizador;
import model.TipoReserva;

import java.util.HashMap;
import java.util.Map;

public class LocalizadorRepository {
    public int cantidadTotalReservas() {
        return Db.clientes.values().stream()
                .flatMap(c -> c.getLocalizadores().stream())
                .mapToInt(l -> l.getReservas().size())
                .sum();
    }

    public Map<TipoReserva, Long> obtenerReservasClasificadas() {
        Map<TipoReserva, Long> clasificacion = new HashMap<>();
        Db.clientes.values().forEach(cliente -> {
            cliente.getLocalizadores().forEach(localizador -> {
                localizador.getReservas().forEach(reserva -> {
                    clasificacion.put(reserva.getTipo(), clasificacion.getOrDefault(reserva.getTipo(), 0L) + 1);
                });
            });
        });
        return clasificacion;
    }

    public double totalVentas() {
        return Db.clientes.values().stream()
                .flatMap(c -> c.getLocalizadores().stream())
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public double promedioVentas() {
        return Db.clientes.values().stream()
                .flatMap(c -> c.getLocalizadores().stream())
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0);
    }
}
