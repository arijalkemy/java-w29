package org.example;

import java.util.Arrays;
import java.util.List;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {

        Prenda prenda1 = new Prenda("Marea", "remera");
        Prenda prenda2 = new Prenda("Nike", "pantalon");

        List<Prenda> prendas = Arrays.asList(prenda1, prenda2);

        GuardarRopa guardarRopa = new GuardarRopa(new HashMap<>(),1);
        int id= guardarRopa.guardarPrenda(prendas);


        guardarRopa.mostrarPrenda();

        guardarRopa.devolverPrenda(id);

    }
}