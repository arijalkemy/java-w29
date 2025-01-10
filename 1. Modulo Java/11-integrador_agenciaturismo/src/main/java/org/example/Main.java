package org.example;

import org.example.clases.Cliente;
import org.example.clases.Localizador;
import org.example.clases.Reserva;
import org.example.clases.TipoReserva;
import org.example.repositorios.ImplementacionRepositoryLocalizador;
import org.example.repositorios.Implementacionrepositorycliente;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Implementacionrepositorycliente clienteRepo = new Implementacionrepositorycliente();
        ImplementacionRepositoryLocalizador localizadorRepo = new ImplementacionRepositoryLocalizador();
        Double totalLoc = 0.0;


        //Crear un localizador con un paquete completo para un cliente, almacenar e imprimir el resultado.

        //Crear cliente
        Cliente c1 = new Cliente(1, "Franca", "Pairetti", "franpairetti@gmail.com", "42567877");
        clienteRepo.buscarOAgragrCliente(c1);

        //crear tipos de reservas
        TipoReserva tr1 = new TipoReserva("Hotel", 1);
        TipoReserva tr2 = new TipoReserva("Comida", 2);
        TipoReserva tr3 = new TipoReserva("Boleto", 3);
        TipoReserva tr4 = new TipoReserva("Transporte", 4);

        //crear una reserva de casa tipo
        Reserva r1 = new Reserva(1, "Hotel", tr1, 5800.0);
        Reserva r2 = new Reserva(2, "Comida", tr2, 800.0);
        Reserva r3 = new Reserva(3, "Boleto", tr3, 600.0);
        Reserva r4 = new Reserva(4, "Transporte", tr4, 600.0);

        //Crear un localizador completo
        Localizador l1 = new Localizador(1, c1, Arrays.asList(r1, r2, r3, r4));
        totalLoc = localizadorRepo.calcularPrecio(c1, Arrays.asList(r1, r2, r3, r4));
        l1.setValorTotal(totalLoc);
        localizadorRepo.agregarLocalizador(l1);


        //imprimir resultado
        System.out.println("-----Localizador de paquete completo-----");
        System.out.println(l1.toString());


        //Crear un localizador con 2 reservas de hotel y 2 de boletos para el mismo cliente anterior,
        // almacenar e imprimir el resultado.

        Reserva r5 = new Reserva(5, "Hotel 2", tr1, 7800.0);
        Reserva r6 = new Reserva(6, "Hotel 3", tr1, 4990.0);
        Reserva r7 = new Reserva(7, "Boleto 2", tr3, 1000.0);
        Reserva r8 = new Reserva(8, "Boleto 3", tr3, 1000.0);

        Localizador l2 = new Localizador(2, c1, Arrays.asList(r5, r6, r7, r8));
        totalLoc = localizadorRepo.calcularPrecio(c1, Arrays.asList(r5, r6, r7, r8));
        l2.setValorTotal(totalLoc);
        localizadorRepo.agregarLocalizador(l2);

        System.out.println("-----Localizador de reserva de dos hotoles y dos boletos-----");
        System.out.println(l2.toString());


        //Crear un localizador con una sola reserva para el mismo cliente.
        Reserva r9 = new Reserva(9, "Transporte", tr4, 700.0);

        Localizador l3 = new Localizador(3, c1, Arrays.asList(r9));
        totalLoc = localizadorRepo.calcularPrecio(c1, Arrays.asList(r9));
        l3.setValorTotal(totalLoc);
        localizadorRepo.agregarLocalizador(l3);


        System.out.println("-----Localizador de reserva con 1 sola reserva-----");
        System.out.println(l3.toString());


        //Cantidad de localizadores vendidos.
        System.out.println("-----la cantidad de localizadores vendidos es: " + localizadorRepo.localizadoresVendidos() + " -------");

        //Cantidad total de reservas.
        System.out.println("---La cantidad total de reservas es: " + localizadorRepo.reservasVendidas() + " ---");

        //Obtener un diccionario de todas las reservas clasificados por tipo (hotel, boleto,comida,transporte).


        //Total de ventas.


        //Promedio de todas las ventas.

    }
}