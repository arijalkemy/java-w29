import java.util.HashMap;
import java.util.Map;

public class RepositorioCliente {
    private Map<String, Cliente> clientes;

    public RepositorioCliente() {
        clientes = new HashMap<>();
    }

    public Cliente obtenerCliente(String clave) {
        return clientes.get(clave);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.put(cliente.getNombre() + " " + cliente.getApellido(), cliente);
    }

    public int cantidadTotalLocalizadores() {
        return clientes.values().stream()
                .mapToInt(c -> c.getLocalizadores().size())
                .sum();
    }

    public int cantidadTotalReservas() {
        return clientes.values().stream()
                .flatMap(c -> c.getLocalizadores().stream())
                .mapToInt(l -> l.getReservas().size())
                .sum();
    }

    public Map<String, Long> obtenerReservasClasificadas() {
        Map<String, Long> clasificacion = new HashMap<>();
        clientes.values().forEach(cliente -> {
            cliente.getLocalizadores().forEach(localizador -> {
                localizador.getReservas().forEach(reserva -> {
                    clasificacion.put(reserva.getTipo(), clasificacion.getOrDefault(reserva.getTipo(), 0L) + 1);
                });
            });
        });
        return clasificacion;
    }

    public double totalVentas() {
        return clientes.values().stream()
                .flatMap(c -> c.getLocalizadores().stream())
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public double promedioVentas() {
        long totalLocalizadores = cantidadTotalLocalizadores();
        return totalLocalizadores == 0 ? 0 : totalVentas() / totalLocalizadores;
    }
}