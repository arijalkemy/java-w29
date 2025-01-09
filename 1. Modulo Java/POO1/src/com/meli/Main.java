package com.meli;

public class Main {

    public static void main(String[] args) {
	    Libro libro = new Libro("Titulo", "Juanito", 20);

	    System.out.println(libro.mostrarLibro());
        System.out.println("La cantidad de ejemplares para este titulo es: " + libro.cantidadDeEjemplares());
    }
}
