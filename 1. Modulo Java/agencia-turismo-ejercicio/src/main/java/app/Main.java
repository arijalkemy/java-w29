package app;

import models.Cliente;
import models.Localizador;
import models.Reserva;
import models.TipoReserva;
import repositories.ClienteRepository;
import repositories.ClienteRepositoryImpl;
import repositories.LocalizadorRepository;
import repositories.LocalizadorRepositoryImpl;
import services.ClienteService;
import services.LocalizadorService;

import java.util.List;

public class Main {
    public static void main(String[] args) {

        //Repositorios
        ClienteRepository clienteRepository = new ClienteRepositoryImpl();
        LocalizadorRepository localizadorRepository = new LocalizadorRepositoryImpl();

        //Servicios
        ClienteService clienteService = new ClienteService(clienteRepository);
        LocalizadorService localizadorService = new LocalizadorService(localizadorRepository, clienteService);


        //Crear cliente
        Cliente cliente = clienteService.crearCliente("Juan perez");

        //Crear localizador con un paquete completo
        List<Reserva> paqueteCompleto = List.of(
                new Reserva(TipoReserva.HOTEL, 200),
                new Reserva(TipoReserva.COMIDA, 50),
                new Reserva(TipoReserva.BOLETOS, 300),
                new Reserva(TipoReserva.TRANSPORTE, 100)
        );

        Localizador localizador1 = localizadorService.crearLocalizador(cliente,paqueteCompleto);

        System.out.println("Localizador creado");
        System.out.println(localizador1);


        //Crear un localizador con 2 reservas de hotel 2 boletos
        List<Reserva> hotelyBoletos = List.of(
                new Reserva(TipoReserva.HOTEL, 200),
                new Reserva(TipoReserva.HOTEL, 200),
                new Reserva(TipoReserva.BOLETOS, 300),
                new Reserva(TipoReserva.BOLETOS, 300)
        );
        Localizador localizador2 = localizadorService.crearLocalizador(cliente, hotelyBoletos);
        System.out.println("Localizador creado");
        System.out.println(localizador2);

        //Crear un localizador con una sola reserva
        List<Reserva> reservaSola = List.of(
                new Reserva(TipoReserva.HOTEL, 200)
        );
        Localizador localizador3 = localizadorService.crearLocalizador(cliente, reservaSola);
        System.out.println("Localizador creado");
        System.out.println(localizador3);

        //Cantidad de localizadores vendidos
        System.out.println("Localizadores vendidos: " + localizadorService.getCantidadLocalizadoresVendidos());

        //Cantidad total reservas
        System.out.println("Reservas vendidas: " + localizadorService.getCantidadTotalReservas());


        // Reservas clasificadas
        System.out.println("Reservas por tipo: ");
        System.out.println(localizadorService.getReservasClasificadasStreams());

        //Total de ventas
        System.out.println("Total de ventas: " + localizadorService.getTotalVentas());

        //Promedio de ventas
        System.out.println("Promedio de ventas: " + localizadorService.getPromedioVentas());

    }
}
