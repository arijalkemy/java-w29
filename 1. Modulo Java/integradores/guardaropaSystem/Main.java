package com.example.demo.integradores.guardaropaSystem;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardarropa = new GuardaRopa();

        Prenda prenda1 = new Prenda("Nike", "Campera Deportiva");
        Prenda prenda2 = new Prenda("Adidas", "Pantalon Clasic");

        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);
        Integer codigo = guardarropa.guardarPrendas(prendas);

        System.out.println("Prendas guardadas con el codigo: " + codigo);

        System.out.println("\nPrendas en el guardarropa:");
        guardarropa.mostrarPrendas();

        List<Prenda> prendasRecuperadas = guardarropa.devolverPrendas(codigo);
        System.out.println("\nPrendas recuperadas:");
        prendasRecuperadas.forEach(System.out::println);

        System.out.println("\nEstado actual del guardarropa:");
        guardarropa.mostrarPrendas();
    }
}