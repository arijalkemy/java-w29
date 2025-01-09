package com.thiagoschreck.local;

import com.thiagoschreck.local.agencia.Analizador;
import com.thiagoschreck.local.agencia.Cliente;
import com.thiagoschreck.local.agencia.Localizador;
import com.thiagoschreck.local.agencia.Reserva;

import java.util.List;

public class App {
    public static void main(String[] args) {
        Cliente cliente = new Cliente("Johnny", "Test", "1.234.567-8");
        List<Reserva> paquete = List.of(
                new Reserva(1000, Reserva.Tipo.BOLETO),
                new Reserva(1500, Reserva.Tipo.COMIDA),
                new Reserva(4000, Reserva.Tipo.HOTEL),
                new Reserva(1030, Reserva.Tipo.TRANSPORTE)
        );
        Localizador localizador = new Localizador(paquete, cliente);
        System.out.println(localizador);

        System.out.println("-----------");

        Localizador localizador2 = new Localizador(List.of(new Reserva(100, Reserva.Tipo.TRANSPORTE)), cliente);
        System.out.println(localizador2);

        System.out.println("-----------");

        Analizador.imprimirDatos();
    }
}
