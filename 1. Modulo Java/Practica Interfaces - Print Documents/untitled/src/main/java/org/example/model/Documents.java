package org.example.model;

public interface Documents {

    String contentToPrint();

    static void imprimir(Documents documento) {
        System.out.println(documento.contentToPrint());
    }

}
