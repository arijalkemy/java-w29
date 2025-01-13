package com.example.demo.integradores.guardaropaSystem;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Crear la clase GuardaRopa que contenga como atributos un diccionario
(o MAP) y un contador que se utilizará como identificador.
Las claves del diccionario serán de tipo entero y como valor una lista deprendas
 */
class GuardaRopa {
    private Map<Integer, List<Prenda>> prendasGuardadas;
    private int contador;

    public GuardaRopa() {
        this.prendasGuardadas = new HashMap<>();
        this.contador = 0;
    }

    /*
    Crear el método public Integer guardarPrendas(List<Prenda>
    listaDePrenda),en la Clase GuardaRopa, que recibe una lista de
     prendas y devuelve el número identificador en donde quedaron asignadas las prendas,
     es decir la clave del diccionario en donde guardamos las mismas.
     */
    public Integer guardarPrendas(List<Prenda> listaDePrenda) {
        contador++;  // contador
        prendasGuardadas.put(contador, listaDePrenda);
        return contador;
    }

    public void mostrarPrendas() {
        prendasGuardadas.forEach((numero, prendas) -> {
            System.out.println("Número: " + numero);
            prendas.forEach(prenda -> System.out.println(" - " + prenda));
        });
    }
    /*
    Crear el método public List<Prenda> devolverPrendas(Integer numero),
    en la Clase GuardaRopa que devuelve la lista de prendas que están guardadas bajo ese número.
     */
    public List<Prenda> devolverPrendas(Integer numero) {
        // return prendasGuardadas.remove(numero); // hard delete
        return prendasGuardadas.get(numero); //
    }
}