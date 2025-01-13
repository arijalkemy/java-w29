import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Agencia {
    private final RepositorioCliente repositorio;

    public Agencia() {
        this.repositorio = new RepositorioCliente();
    }

    public Localizador crearLocalizador(String nombreCliente, List<Reserva> reservas) {
        Cliente cliente = repositorio.obtenerCliente(nombreCliente);
        if (cliente == null) {
            cliente = new Cliente(nombreCliente);
            repositorio.agregarCliente(cliente);
        }

        // Aplicar descuentos
        aplicarDescuentos(cliente, reservas);

        // Crear localizador
        Localizador localizador = new Localizador(cliente, reservas);
        cliente.agregarLocalizador(localizador);
        return localizador;
    }

    private void aplicarDescuentos(Cliente cliente, List<Reserva> reservas) {
        // Descuento del 5% si el cliente tiene más de 2 localizadores previos
        if (cliente.getLocalizadores().size() >= 2) {
            reservas.forEach(reserva -> reserva.aplicarDescuento(5));
        }

        // Descuento del 10% si el paquete es completo
        if (tienePaqueteCompleto(reservas)) {
            reservas.forEach(reserva -> reserva.aplicarDescuento(10));
        }

        // Descuento del 5% para 2 reservas del mismo tipo
        Map<Reserva.Tipo, Long> conteo = reservas.stream()
                .collect(Collectors.groupingBy(Reserva::getTipo, Collectors.counting()));

        conteo.forEach((tipo, cantidad) -> {
            if (cantidad >= 2) {
                reservas.stream()
                        .filter(reserva -> reserva.getTipo() == tipo)
                        .forEach(reserva -> reserva.aplicarDescuento(5));
            }
        });
    }

    private boolean tienePaqueteCompleto(List<Reserva> reservas) {
        return reservas.stream().map(Reserva::getTipo).collect(Collectors.toSet())
                .containsAll(Arrays.asList(Reserva.Tipo.values()));
    }

    public RepositorioCliente getRepositorio() {
        return repositorio;
    }
}
