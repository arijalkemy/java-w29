package com.javadocum.documentos;

import java.util.ArrayList;
import java.util.List;

public final class DocumentosApplication {
    private DocumentosApplication() {
    }

    public static void main(String[] args) {
        List<String> skills = new ArrayList<String>();
        skills.add("Desarrollo");
        skills.add("Planeación");
        Documento curriculum = new Curriculum("Pepe", "Programador", skills);

        Documento libro = new Libro(250, "J.K.Rowling", "Harry Potter", "Fantasia");

        Documento informe = new Informe("Texto del informe", 2, "Nombre Autor", "Lider");

        Imprimible.imprimir(curriculum);

        Imprimible.imprimir(libro);

        Imprimible.imprimir(informe);
    }
}