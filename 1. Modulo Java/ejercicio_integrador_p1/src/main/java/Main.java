import model.Cliente;
import model.Localizador;
import model.Reserva;
import model.TipoReserva;
import repository.ClienteRepository;
import repository.LocalizadorRepository;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        ClienteRepository repositorio = new ClienteRepository();
        LocalizadorRepository localizadorRepository = new LocalizadorRepository();

        Cliente cliente1 = new Cliente("Juan", "Pérez");
        Cliente cliente2 = new Cliente("Holmes", "Ramirez");

        repositorio.agregarCliente(cliente1);
        repositorio.agregarCliente(cliente2);

        Localizador localizador1 = new Localizador(cliente1, Arrays.asList(
                new Reserva(TipoReserva.HOTEL, 1000),
                new Reserva(TipoReserva.COMIDA, 200),
                new Reserva(TipoReserva.BOLETOS, 500),
                new Reserva(TipoReserva.TRANSPORTE, 300)
        ));
        cliente1.addLocalizador(localizador1);
        System.out.println(localizador1);

        Localizador localizador2 = new Localizador(cliente1, Arrays.asList(
                new Reserva(TipoReserva.HOTEL, 1200),
                new Reserva(TipoReserva.HOTEL, 1100),
                new Reserva(TipoReserva.BOLETOS, 600),
                new Reserva(TipoReserva.BOLETOS, 550)
        ));
        cliente1.addLocalizador(localizador2);
        System.out.println(localizador2);

        Localizador localizador3 = new Localizador(cliente1, List.of(
                new Reserva(TipoReserva.COMIDA, 150)
        ));
        cliente1.addLocalizador(localizador3);
        System.out.println(localizador3);

        Localizador localizador4 = new Localizador(cliente2, Arrays.asList(
                new Reserva(TipoReserva.HOTEL, 1200),
                new Reserva(TipoReserva.HOTEL, 1100)
        ));
        cliente2.addLocalizador(localizador4);
        System.out.println(localizador4);

        System.out.println("\nCantidad de localizadores vendidos: " + repositorio.cantidadTotalLocalizadores());
        System.out.println("Cantidad total de reservas: " + localizadorRepository.cantidadTotalReservas());

        Map<TipoReserva, Long> reservasClasificadas = localizadorRepository.obtenerReservasClasificadas();
        System.out.println("Reservas clasificadas por tipo: " + reservasClasificadas);

        double totalVentas = localizadorRepository.totalVentas();
        System.out.println("Total de ventas: " + totalVentas);

        double promedioVentas = localizadorRepository.promedioVentas();
        System.out.println("Promedio de ventas: " + promedioVentas);
    }
}
