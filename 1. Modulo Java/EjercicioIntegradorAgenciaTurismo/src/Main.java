import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("----- INICIANDO PROGRAMA -----");
        Agencia agencia = new Agencia();

        // Parte I: Crear localizadores
        List<Reserva> paqueteCompleto = Arrays.asList(
                new Reserva(Reserva.Tipo.HOTEL, 200),
                new Reserva(Reserva.Tipo.COMIDA, 100),
                new Reserva(Reserva.Tipo.BOLETO, 300),
                new Reserva(Reserva.Tipo.TRANSPORTE, 150)
        );

        List<Reserva> dosReservas = Arrays.asList(
                new Reserva(Reserva.Tipo.HOTEL, 200),
                new Reserva(Reserva.Tipo.HOTEL, 200),
                new Reserva(Reserva.Tipo.BOLETO, 300),
                new Reserva(Reserva.Tipo.BOLETO, 300)
        );

        List<Reserva> unaReserva = Collections.singletonList(
                new Reserva(Reserva.Tipo.HOTEL, 200)
        );

        Localizador loc1 = agencia.crearLocalizador("Juan Perez", paqueteCompleto);
        System.out.println(loc1);

        Localizador loc2 = agencia.crearLocalizador("Juan Perez", dosReservas);
        System.out.println(loc2);

        Localizador loc3 = agencia.crearLocalizador("Juan Perez", unaReserva);
        System.out.println(loc3);

        // Parte II: Consultas
        System.out.println("Localizadores vendidos: " + ConsultasOperaciones.cantidadLocalizadoresVendidos(agencia.getRepositorio()));
        System.out.println("Reservas totales: " + ConsultasOperaciones.cantidadTotalReservas(agencia.getRepositorio()));
        System.out.println("Reservas por tipo: " + ConsultasOperaciones.reservasPorTipo(agencia.getRepositorio()));
        System.out.println("Total de ventas: " + ConsultasOperaciones.totalVentas(agencia.getRepositorio()));
        System.out.println("Promedio de ventas: " + ConsultasOperaciones.promedioVentas(agencia.getRepositorio()));
    }
}