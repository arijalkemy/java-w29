package com.example;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Prenda> prendas1 = new ArrayList<>(List.of(
                new Prenda("Adidas", "Climalite"),
                new Prenda("The North Face", "ThermoBall Eco"),
                new Prenda("Zara", "Classic Wool Coat")
        ));

        List<Prenda> prendas2 = new ArrayList<>(List.of(
                new Prenda("Schott NYC", "Perfecto 618"),
                new Prenda("Patagonia", "Down Sweater")
        ));

        GuardaRopa guardaRopa = new GuardaRopa();

        guardaRopa.guardarPrendas(prendas1);
        guardaRopa.guardarPrendas(prendas2);

        guardaRopa.mostrarPrendas();
    }
}
