package org;

public class Main {
    public static void main(String[] args) {

        Libro libro = new Libro("Harry potter", "J K Roling ", 20);


        System.out.println(libro.mostrarLibro());
        System.out.println("Cantidad de ejemplares para este libro es de " + libro.cantidadEjemplares());
    }
}