import procesador.Curriculum;
import procesador.Imprimible;
import procesador.Informes;
import procesador.LibroPDF;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> lista = new ArrayList<>();
        lista.add("Amistoso");
        lista.add("Compañerista");
        lista.add("Tiene mala retentiva");

        Imprimible curriculum = new Curriculum("Andres Felipe",
                "Galeano Alarcon",
                "312348459",
                "galitest@gmail.com", lista);
        Imprimible.imprimirDocumento(curriculum);

        Imprimible libroPdf = new LibroPDF(120,
                "Do Flamingo",
                "Generic Devil Fruits",
                "Ciencia Ficción");
        Imprimible.imprimirDocumento(libroPdf);

        Imprimible informe = new Informes("validación de multiples factores interventores en el colapso de una estrella",
                28, "Stephen Hacking", "London College");
        Imprimible.imprimirDocumento(informe);
    }
}