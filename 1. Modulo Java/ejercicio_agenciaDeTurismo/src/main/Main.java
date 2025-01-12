package main;

import model.Cliente;
import model.Localizador;
import model.Reserva;
import repository.Repositorio;
import service.Consultas;

public class Main {
    public static void main(String[] args) {
        /* Crear un localizador con un paquete completo para un cliente,
         almacenar e imprimir el resultado.
         */
        Cliente cliente = new Cliente("Christian", "Bravo", 12345678);
        Localizador localizador = new Localizador(cliente);
        Reserva hotel = new Reserva("model.Hotel", 10000.0);
        Reserva comida = new Reserva("model.Comida", 500.0);
        Reserva transporte = new Reserva("model.Transporte", 4000.0);
        Reserva boleto= new Reserva("Boleto de viaje", 600.0);

        localizador.agregarReserva(hotel);
        localizador.agregarReserva(comida);
        localizador.agregarReserva(transporte);
        localizador.agregarReserva(boleto);

        Repositorio repositorio = new Repositorio();
        repositorio.agregarLocalizador(cliente, localizador);

        int cantidadLocalizadoresCliente = repositorio.obtenerCantidadLocalizadoresCliente(cliente).size();
        localizador.calcularTotal(cantidadLocalizadoresCliente);
        System.out.println(localizador);

         /* Crear un localizador con 2 reservas de hotel y
          2 de boletos para el mismo cliente anterior,
          almacenar e imprimir el resultado.
         */

        Reserva hotel_1 = new Reserva("model.Hotel", 10000.0);
        Reserva hotel_2 = new Reserva("model.Hotel", 500.0);
        Reserva boleto_1 = new Reserva("Boleto de viaje", 600.0);
        Reserva boleto_2 = new Reserva("Boleto de viaje", 900.0);
        Localizador localizador_2 = new Localizador(cliente);
        localizador_2.agregarReserva(hotel_1);
        localizador_2.agregarReserva(hotel_2);
        localizador_2.agregarReserva(boleto_1);
        localizador_2.agregarReserva(boleto_2);

        repositorio.agregarLocalizador(cliente, localizador_2);
        cantidadLocalizadoresCliente = repositorio.obtenerCantidadLocalizadoresCliente(cliente).size();
        localizador_2.calcularTotal(cantidadLocalizadoresCliente);
        System.out.println(localizador_2);

          /* Crear un localizador con una sola reserva para el mismo cliente.*/
        Localizador localizador_3 = new Localizador(cliente);
        Reserva hotel_3 = new Reserva("model.Hotel", 10000.0);
        localizador_3.agregarReserva(hotel_3);
        repositorio.agregarLocalizador(cliente, localizador_3);
        cantidadLocalizadoresCliente = repositorio.obtenerCantidadLocalizadoresCliente(cliente).size();
        localizador_3.calcularTotal(cantidadLocalizadoresCliente);
        System.out.println(localizador_3);

        System.out.println("Parte II (Opcional)");

        /*Cantidad de localizadores vendidos.*/
        Consultas consultas = new Consultas(repositorio);
        System.out.println("La cantidad de localizadores vendidos son: " +consultas.obtenerCantidadLocalizadoresVendidos());

        /*Cantidad total de reservas.*/
        System.out.println("La cantidad total de reservas son: " +consultas.obtenerCantidadReservas());

        /*Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).*/
        System.out.println("Diccionario de todas las reservas clasificados por tipo: " +consultas.obtenerDiccionarioCantidadDeReservas());

        /*Total de ventas.*/
        System.out.println("El total de ventas es: " +consultas.calcularTotalVentas());

        /*Promedio de todas las ventas.*/
        System.out.println("El total de ventas es: " +consultas.calcularPromedioVentas());




    }
}