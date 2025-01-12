package org.example;

import org.example.documentos.Curriculums;
import org.example.documentos.Informes;
import org.example.documentos.LibrosPdf;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Informes informe = new Informes("Primer texto prueba",1,"David","Gabriela");
        LibrosPdf libro = new LibrosPdf(1,"Informativo", "Primer libro", "Juan");
        Curriculums cv = new Curriculums("Alcira", 60, 5161365);
        cv.agregarHabilidade("Proactiva");
        cv.agregarHabilidade("Comunicativa");
        cv.agregarHabilidade("Respetuosa");
        cv.agregarHabilidade("Adaptable");

        System.out.println("Impresión de documentos...");
        System.out.println("Informe: ");
        informe.imprimir();
        System.out.println("                          ");
        System.out.println("Libro: ");
        libro.imprimir();
        System.out.println("                          ");
        System.out.println("Curriculum: ");
        cv.imprimir();

    }
}