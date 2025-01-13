package ej2;

import java.util.List;

public class ej2 {
    public static void main(String[] args) {
        Imprimible curriculum = new Curriculum(
                "Nicolas",
                "nicolas@email.com",
                "099999999",
                List.of(
                        "habilidad1",
                        "habilidad2"
                )
        );

        Imprimible libro = new LibroPDF(
                60,
                "Nicolas",
                "Libro",
                "Terror"
        );

        Imprimible informe = new Informe(
                "Contenido",
                50,
                "Nicolas",
                "Maria"
        );

        curriculum.imprimir();
        libro.imprimir();
        informe.imprimir();
    }
}
