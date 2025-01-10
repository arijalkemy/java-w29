package ejercicio_2;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> habilidades = new ArrayList<>();
        habilidades.add("A");
        habilidades.add("B");
        habilidades.add("C");

        Curriculum curriculum = new Curriculum("Felipe Ladino", 90, habilidades);
        LibroPDF libro = new LibroPDF(30, "El infinito en un junco", "Irene Vallejo", "Ensayo");
        Informe informe = new Informe(50, 13, "Lorenzo Perez", "David Carranza");

        Impresora.imprimirDocumento(curriculum);
        Impresora.imprimirDocumento(libro);
        Impresora.imprimirDocumento(informe);

    }
}
