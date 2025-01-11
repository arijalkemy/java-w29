package org.example.Ejercicio2;

import java.util.List;

public class Main {
    public static void imprimirDocumento(Imprimible imprimir) {
        imprimir.imprimir();

    }

    public static void main(String[] args) {
        //Crear los objetos
        Curriculum curriculum1 = new Curriculum("Silvia", 28, List.of("Java", "Python"));
        imprimirDocumento(curriculum1);

        Informe informe1 = new Informe("texto1","Stiven","Juan",20);
        imprimirDocumento(informe1);

        LibroPDF libroPDF1 = new LibroPDF(30,"terror","yo","mi titulo");
        imprimirDocumento(libroPDF1);

    }
}
