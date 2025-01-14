package ejercicioIntegrador;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Juan Perez", "12345678");

        RepositorioCliente repositorio = new RepositorioCliente();

        // Crear un localizador con un paquete completo
        List<Reserva> reservasPaqueteCompleto = List.of(
                new Reserva(Reserva.Tipo.HOTEL, 100),
                new Reserva(Reserva.Tipo.COMIDA, 50),
                new Reserva(Reserva.Tipo.BOLETOS, 200),
                new Reserva(Reserva.Tipo.TRANSPORTE, 75)
        );
        repositorio.aplicarDescuentosYGuardar(new Localizador(cliente, reservasPaqueteCompleto, 425));

        // Crear un localizador con 2 reservas de hotel y 2 de boletos
        List<Reserva> reservasHotelesYBoletos = List.of(
                new Reserva(Reserva.Tipo.HOTEL, 100),
                new Reserva(Reserva.Tipo.HOTEL, 100),
                new Reserva(Reserva.Tipo.BOLETOS, 200),
                new Reserva(Reserva.Tipo.BOLETOS, 200)
        );
        repositorio.aplicarDescuentosYGuardar(new Localizador(cliente, reservasHotelesYBoletos, 600));

        // Crear un localizador con una sola reserva
        List<Reserva> unaReserva = List.of(
                new Reserva(Reserva.Tipo.HOTEL, 100)
        );
        repositorio.aplicarDescuentosYGuardar(new Localizador(cliente, unaReserva, 100));
    }
}