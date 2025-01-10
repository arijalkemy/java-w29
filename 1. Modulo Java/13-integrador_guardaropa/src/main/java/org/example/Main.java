package org.example;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //Crear en la clase Main un escenario en el cual alguien guarde dos prendas, reciba el código y
        // luego consulta por sus prendas guardadas.

        //crear dos prendas
        Prendas p1 = new Prendas("Nike", "Campera");
        Prendas p2 = new Prendas("Adidas", "Buzo");

        GuardaRopa gr1=new GuardaRopa();

        gr1.guardarPrendas(Arrays.asList(p1,p2));

        gr1.mostrarPrendas();
    }
}