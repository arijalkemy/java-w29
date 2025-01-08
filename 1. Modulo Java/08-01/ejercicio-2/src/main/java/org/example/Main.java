package org.example;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Persona persona = new Persona("Martin", "Pombo", 23);
        Documento cv = new Curriculum(persona, List.of("Programación", "Inglés", "Analista de Sistemas", "Java", "JavaScript", "Kotlin"));
        Documento pdf = new PDF(2, "Martín Pombo", "Aprendiendo JAVA", "Programación");
        Documento informe = new Informe("Lorem ipsum dolor sit amet", 1, "Martín Pombo", "Matias Len");

        System.out.println("-------------IMPRIMIENDO CV-------------");
        Imprimible.imprimir(cv);
        System.out.println("-------------IMPRIMIENDO PDF-------------");
        Imprimible.imprimir(pdf);
        System.out.println("-------------IMPRIMIENDO INFORME-------------");
        Imprimible.imprimir(informe);
    }
}