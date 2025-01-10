package org.example.clases;

import org.example.interfaces.Imprimir;

public class Main {
    public static void main(String[] args) {
        //Representar un escenario donde se creen cada uno de estos objetos y que, por medio de un método
        // estático de una interfaz imprimible, se pueda pasar cualquier tipo de documento y sea impreso
        // el contenido.

        Curriculum cv = new Curriculum("Franca","Pairetti","42785599",24);
        cv.agregarhabilidad("Programación");
        cv.agregarhabilidad("Responsable");

        Libros libro = new Libros("ABC", "Francis",345,"Novela");

        Informe inform = new Informe("Yuliana", "David",82,"Este es el gran informe final de yuliana.");

        Imprimir.imprimirDocumento(cv);
        Imprimir.imprimirDocumento(libro);
        Imprimir.imprimirDocumento(inform);
    }
}