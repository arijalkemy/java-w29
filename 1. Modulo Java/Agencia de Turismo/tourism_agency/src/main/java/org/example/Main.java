package org.example;

import org.example.model.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Cliente> repoCliente = new ArrayList<>();
        GestorReservas gestor = new GestorReservas(repoCliente);

        Cliente juan = new Cliente("Juan", new ArrayList<>());
        Cliente pedro = new Cliente("Pedro",new ArrayList<>());
        Cliente roberto = new Cliente("Roberto",new ArrayList<>());

        List<Reserva> reservasDeJuan = new ArrayList<>();
        reservasDeJuan.add(new ReservaHotel(100.0));
        reservasDeJuan.add(new ReservaComida(50.0));
        reservasDeJuan.add(new ReservaBoleto(150.0));
        reservasDeJuan.add(new ReservaTransporte(75.0));

        List<Reserva> reservasDePedro = new ArrayList<>();
        reservasDePedro.add(new ReservaHotel(100.0));
        reservasDePedro.add(new ReservaTransporte(75.0));

        List<Reserva> reservasDeRoberto = new ArrayList<>();
        reservasDeRoberto.add(new ReservaHotel(100.0));
        reservasDeRoberto.add(new ReservaHotel(100.0));
        reservasDeRoberto.add(new ReservaComida(50.0));
        reservasDeRoberto.add(new ReservaBoleto(150.0));
        reservasDeRoberto.add(new ReservaTransporte(75.0));

        // Crear localizadores
        gestor.generarLocalizador(juan, reservasDeJuan);
        gestor.generarLocalizador(pedro,reservasDePedro);
        gestor.generarLocalizador(roberto,reservasDeRoberto);

    }
}