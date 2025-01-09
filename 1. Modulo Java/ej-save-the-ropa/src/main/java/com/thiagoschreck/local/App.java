package com.thiagoschreck.local;

import com.thiagoschreck.local.model.GuardaRopa;
import com.thiagoschreck.local.model.Prenda;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class App {
    private static final GuardaRopa guardaRopa = new GuardaRopa();
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        abrirMenu();
    }

    private static void abrirMenu() {
        while(true) {
            System.out.print("""
                --------------------------
                Bienvenido al guardarropas
                --------------------------
                1- Guardar prendas
                2- Consultar prendas
                \s
                0- Salir
                \s
                Opción:\s""");
            switch (scanner.next()) {
                case "1" -> guardarPrendas();
                case "2" -> verPrendasGuardadas();
                case "0" -> {
                    scanner.close();
                    return;
                }
            }
        }
    }

    private static void guardarPrendas() {
        System.out.println("Ingrese una prenda:");
        List<Prenda> prendas = new ArrayList<>();
        prendas.add(ingresarPrenda());
        System.out.println("Ingrese otra prenda:");
        prendas.add(ingresarPrenda());
        Integer codigoPrendas = guardaRopa.guardarPrendas(prendas);
        System.out.printf("%nSu código es %s%n%n", codigoPrendas);
    }

    private static void verPrendasGuardadas() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el código de sus prendas: ");
        List<Prenda> prendas = guardaRopa.devolverPrendas(Integer.valueOf(scanner.next()));
        if (prendas == null || prendas.isEmpty()) {
            System.out.println("No existen prendas para el código especificado");
            return;
        }
        System.out.printf("""
                Prendas:
                --------
                %s%n
                """, prendas.stream()
                .map(prenda -> String.format("* %s", prenda.toString()))
                .collect(Collectors.joining("\n")));
    }

    private static Prenda ingresarPrenda() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("-  Marca: ");
        String marca = scanner.next();
        System.out.print("-  Modelo: ");
        String modelo = scanner.next();
        System.out.println();
        return new Prenda(marca, modelo);
    }
}
