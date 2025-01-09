package app;

import models.GuardaRopa;
import models.Prenda;

import java.util.List;

public class Main {

    public static void main(String[] args) {

        //Crear guardaropa
        GuardaRopa guardaRopa = new GuardaRopa();

        //Crear prendas
        List<Prenda> prendas = List.of(
                new Prenda("marca1", "modelo1"),
                new Prenda("marca2", "modelo2")
        );

        //Agregar prendas al guardaropa y obtener codigo
        int codigo = guardaRopa.guardarPrendas(prendas);

        System.out.println("Codigo guardado: " + codigo);

        //Mostrar todas las prendas del guardaropa
        System.out.println("TODAS LAS PRENDAS:");
        guardaRopa.mostrarPrendas();

        //Obtener las prendas guardadas con el codigo y mostrarlas
        List<Prenda> prendasGuardadas = guardaRopa.devolverPrendas(codigo);
        System.out.println("Lista de prendas: ");
        prendasGuardadas.forEach(System.out::println);


    }
}
