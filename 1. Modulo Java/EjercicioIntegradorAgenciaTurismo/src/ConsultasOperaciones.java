import java.util.Map;
import java.util.stream.Collectors;

public class ConsultasOperaciones {
    public static long cantidadLocalizadoresVendidos(RepositorioCliente repositorio) {
        return repositorio.getClientes().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .count();
    }

    public static long cantidadTotalReservas(RepositorioCliente repositorio) {
        return repositorio.getClientes().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .flatMap(localizador -> localizador.getReservas().stream())
                .count();
    }

    public static Map<Reserva.Tipo, Long> reservasPorTipo(RepositorioCliente repositorio) {
        return repositorio.getClientes().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .flatMap(localizador -> localizador.getReservas().stream())
                .collect(Collectors.groupingBy(Reserva::getTipo, Collectors.counting()));
    }

    public static double totalVentas(RepositorioCliente repositorio) {
        return repositorio.getClientes().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .mapToDouble(Localizador::getTotal)
                .sum();
    }

    public static double promedioVentas(RepositorioCliente repositorio) {
        return repositorio.getClientes().stream()
                .flatMap(cliente -> cliente.getLocalizadores().stream())
                .mapToDouble(Localizador::getTotal)
                .average()
                .orElse(0.0);
    }
}
