import Contenedores.Localizador;
import Contenedores.RepositorioLocalizador;
import Reservas.*;
import Usuario.Cliente;
import Usuario.RepositorioCliente;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        RepositorioCliente repositorioCliente = new RepositorioCliente();

        Cliente cliente = new Cliente("1", "Dourado capo");

        List<Reserva> reservasPaqueteCompleto = new ArrayList<>();
        reservasPaqueteCompleto.add(new Comida("Restaurante A", "Ciudad A", "2023-10-01", "12:00", "Italiana", "Centro", 100.0));
        reservasPaqueteCompleto.add(new Vuelo("Aerolinea A", "Ciudad A", "Ciudad B", "2023-10-05", "08:00", "2023-10-10", "18:00", "Economica", 300.0));
        reservasPaqueteCompleto.add(new Hotel("Hotel A", "Ciudad B", "2023-10-05", "2023-10-10", "Centro", "08:00", "xdddddd", 100.0));
        reservasPaqueteCompleto.add(new Transporte("Transporte A", "Ciudad B", "2023-10-05", "2023-10-10", "Centro", "american",50.0));
        Localizador localizadorPaqueteCompleto = new Localizador(cliente, reservasPaqueteCompleto);
        localizadorPaqueteCompleto.imprimirDetalles();
        aplicarDescuentos(localizadorPaqueteCompleto,cliente,repositorioCliente);
        System.out.println("Total con descuento: "+localizadorPaqueteCompleto.getTotal());
        RepositorioLocalizador repositorioLocalizador = new RepositorioLocalizador();
        repositorioLocalizador.agregarLocalizador(localizadorPaqueteCompleto);
        repositorioCliente.agregarLocalizador(cliente, localizadorPaqueteCompleto);

        // Crear un localizador con 2 reservas de hotel y 2 de boletos
        List<Reserva> reservasHotelesVuelos = new ArrayList<>();
        reservasHotelesVuelos.add(new Hotel("Hotel B", "Ciudad C", "2023-11-01", "2023-11-05", "Centro", "08:00", "xd", 100.0));
        reservasHotelesVuelos.add(new Hotel("Hotel C", "Ciudad D", "2023-12-01", "2023-12-05", "Centro", "08:00", "xddd", 100.0));
        reservasHotelesVuelos.add(new Vuelo("Aerolinea B", "Ciudad A", "Ciudad C", "2023-11-01", "08:00", "2023-11-05", "18:00", "Economica", 250.0));
        reservasHotelesVuelos.add(new Vuelo("Aerolinea C", "Ciudad A", "Ciudad D", "2023-12-01", "08:00", "2023-12-05", "18:00", "Economica", 280.0));
        Localizador localizadorHotelesVuelos = new Localizador(cliente, reservasHotelesVuelos);
        localizadorHotelesVuelos.imprimirDetalles();
        aplicarDescuentos(localizadorHotelesVuelos,cliente,repositorioCliente);
        System.out.println("Total con descuento: "+localizadorHotelesVuelos.getTotal());
        repositorioLocalizador.agregarLocalizador(localizadorHotelesVuelos);
        repositorioCliente.agregarLocalizador(cliente, localizadorHotelesVuelos);


        // Crear un localizador con una sola reserva
        List<Reserva> reservasSola = new ArrayList<>();
        reservasSola.add(new Comida("Restaurante B", "Ciudad E", "2023-10-15", "13:00", "Mexicana", "Centro", 80.0));
        Localizador localizadorSola = new Localizador(cliente, reservasSola);
        localizadorSola.imprimirDetalles();
        aplicarDescuentos(localizadorSola,cliente,repositorioCliente);
        System.out.println("Total con descuento: "+localizadorSola.getTotal());
        repositorioLocalizador.agregarLocalizador(localizadorSola);
        repositorioCliente.agregarLocalizador(cliente, localizadorSola);

        ConsultasLocalizadores consultasLocalizadores = new ConsultasLocalizadores(repositorioLocalizador);
        System.out.println("Cant localizadores: "+consultasLocalizadores.obtenerCantidadLocalizadoresVendidos());        consultasLocalizadores.obtenerCantidadTotalReservas();
        System.out.println("Total de reservas: "+consultasLocalizadores.obtenerCantidadTotalReservas());
        System.out.println("Lista de reservas por tipo: \n"+consultasLocalizadores.obtenerReservasPorTipo());
        System.out.println("Total por ventas: "+consultasLocalizadores.obtenerTotalVentas());
        System.out.println("Promedio por venta: "+consultasLocalizadores.obtenerPromedioVentas());
    }
    public static void aplicarDescuentos(Localizador localizador,Cliente cliente, RepositorioCliente repositorioCliente){
        // BUSCO LOS DESCUENTOS
        Double descuento = 0.0;
        if (repositorioCliente.existeCliente(cliente)) {
            int numLocalizadores = repositorioCliente.obtenerNumeroLocalizadores(cliente);
            if (numLocalizadores >= 2) {
                descuento += 5.0;

                System.out.println("Descuento de 5% por mas de 2 localizadores.");
            }
        }
        long cantVuelos =localizador.getReservas().stream().filter(reserva-> reserva instanceof Vuelo).count();
        long cantHoteles =localizador.getReservas().stream().filter(reserva-> reserva instanceof Hotel).count();
        long cantTransportes =localizador.getReservas().stream().filter(reserva-> reserva instanceof Transporte).count();
        long cantComidas =localizador.getReservas().stream().filter(reserva-> reserva instanceof Comida).count();
        if (cantComidas>=1 && cantVuelos>=1 && cantHoteles>=1 && cantTransportes>=1) {
            descuento += 10.0;
            System.out.println("Descuento de 10% por reserva TOTAL.");
        }
        if (cantHoteles>=2 ){
            Double descuentoHotel = 5.0;
            System.out.println("Descuento de en hoteles 5% por mas de 2 hoteles.");
            localizador.getReservas().stream().filter(reserva-> reserva instanceof Hotel).forEach(reserva-> localizador.aplicarDescuentoReserva(reserva, descuentoHotel));
        }
        if (cantVuelos>=2 ){
            Double descuentoVuelo = 5.0;
            System.out.println("Descuento de en vuelos 5% por mas de 2 vuelos.");
            localizador.getReservas().stream().filter(reserva-> reserva instanceof Vuelo).forEach(reserva-> localizador.aplicarDescuentoReserva(reserva, descuentoVuelo));
        }
        localizador.aplicarDescuentoTotal(descuento);



    }
}