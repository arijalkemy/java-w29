package ejercicioIntegrador;

import java.util.ArrayList;
import java.util.List;

public class RepositorioCliente {
    private List<Localizador> localizadores;

    public RepositorioCliente() {
        this.localizadores = new ArrayList<>();
    }

    public void agregarLocalizador(Localizador localizador) {
        localizadores.add(localizador);
    }

    public int contarLocalizadores(Cliente cliente) {
        return (int) localizadores.stream().filter(l -> l.getCliente().equals(cliente)).count();
    }

    public void aplicarDescuentosYGuardar(Localizador localizador) {
        double totalOriginal = localizador.getTotal();
        double descuento = 0;

        if (contarLocalizadores(localizador.getCliente()) >= 2) {
            descuento += 0.05 * localizador.getTotal();
        }

        boolean paqueteCompleto = localizador.getReservas().stream().map(Reserva::getTipo).distinct().count() == 4;
        if (paqueteCompleto) {
            descuento += 0.10 * localizador.getTotal();
        }

        long cuentaHoteles = localizador.getReservas().stream().filter(r -> r.getTipo() == Reserva.Tipo.HOTEL).count();
        long cuentaBoletos = localizador.getReservas().stream().filter(r -> r.getTipo() == Reserva.Tipo.BOLETOS).count();

        if (cuentaHoteles >= 2 || cuentaBoletos >= 2) {
            descuento += 0.05 * totalOriginal;  // Assume discount only applies once even if both conditions are met.
        }

        double totalConDescuento = totalOriginal - descuento;
        Localizador nuevoLocalizador = new Localizador(localizador.getCliente(), localizador.getReservas(), totalConDescuento);
        agregarLocalizador(nuevoLocalizador);

        System.out.println("Localizador creado y almacenado: " + nuevoLocalizador);
    }
}
