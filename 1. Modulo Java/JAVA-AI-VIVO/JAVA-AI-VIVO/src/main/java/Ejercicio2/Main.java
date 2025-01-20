package Ejercicio2;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum("Juan Pérez", 30, List.of("Java", "Python", "Diseño de software"));
        LibroPDF libro = new LibroPDF("El Principito", "Antoine de Saint-Exupéry", "Ficción", 96);
        Informe informe = new Informe("Este es el contenido del informe.", "María Gómez", "Carlos López", 15);

        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(libro);
        Imprimible.imprimir(informe);
    }
}
