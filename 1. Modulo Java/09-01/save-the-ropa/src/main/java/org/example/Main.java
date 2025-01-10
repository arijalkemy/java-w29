package org.example;

import org.example.model.GuardaRopa;
import org.example.model.Prenda;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        GuardaRopa guardaRopa = new GuardaRopa();
        Prenda prenda1 = new Prenda("ReverPass", "Remera");
        Prenda prenda2 = new Prenda("ReverPass", "Pantalón");
        Prenda prenda3 = new Prenda("Zara", "Pantalón");
        Prenda prenda4 = new Prenda("Nike", "Zaptaillas");


        guardaRopa.guardarPrendas(List.of(prenda1, prenda2));
        guardaRopa.guardarPrendas(List.of(prenda3, prenda4));
        System.out.println(guardaRopa.getPrendas());
        System.out.println();
        System.out.println(guardaRopa.getPrendas(1));
    }
}