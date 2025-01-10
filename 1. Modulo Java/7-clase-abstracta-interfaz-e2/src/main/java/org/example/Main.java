package org.example;

import org.example.documentos.Curriculum;
import org.example.documentos.Informe;
import org.example.documentos.LibroEnPDF;
import org.example.documentos.Persona;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Persona p = new Persona("Eliana", "Navarro", 26, new ArrayList<>(Arrays.asList(".NET", "Java")));
        Curriculum c = new Curriculum(p, 1);
        Informe i = new Informe(9, "Esto es un informe", "Eliana Navarro", "Maria Maria");
        LibroEnPDF l = new LibroEnPDF(100, "Jane Austen", "Orgullo y prejuicio", "Novela");

        c.imprimirDocumento();
        i.imprimirDocumento();
        l.imprimirDocumento();
    }
}