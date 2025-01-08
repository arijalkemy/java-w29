package app;

import documentos.Curriculum;
import documentos.Imprimible;
import documentos.Informe;
import documentos.LibroPDF;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Curriculum curriculum = new Curriculum(
                "Juan",
                "Perez",
                "juan@gmail.com",
                Arrays.asList("Java", "React", "Bases de datos")
        );

        LibroPDF libroPDF = new LibroPDF(
                724,
                "Dracula",
                "Bram Stoker",
                "fantasia"
        );

        Informe informe = new Informe(
                "Texto de informe",
                24,
                "Jorge Castro",
                "Ana Perez"
        );

        Imprimible.imprimir(curriculum);
        Imprimible.imprimir(libroPDF);
        Imprimible.imprimir(informe);

    }
}
