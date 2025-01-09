package org.example;
import java.util.Arrays;
//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // Crear un Curriculum
        Curriculums curriculum = new Curriculums("Juan Pérez", 30, "Masculino",Arrays.asList("Java", "SQL", "Comunicación"));

        // Crear un LibroPDF
        LibroPDF libroPDF = new LibroPDF("El Gran Libro de Java", "Juan Pérez", "Tecnología", 300);

        // Crear un Informe
        Informe informe = new Informe("Informe sobre el estado de los proyectos", 5, "Ana García", "Carlos Martínez");

        // Imprimir los documentos
        System.out.println("\nImpresión de documentos:");
        Documento.verDocumento(curriculum);  // Imprime el curriculum
        Documento.verDocumento(libroPDF);    // Imprime el libro en PDF
        Documento.verDocumento(informe);     // Imprimir el informe
    }
}