import clases.Curriculum;
import clases.Informe;
import clases.LibroPDF;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        ArrayList<String> habilidades = new ArrayList<>();
        habilidades.add("Java");
        habilidades.add("SQL");
        habilidades.add("Trabajo en equipo");
        Curriculum curriculum = new Curriculum("Juan", "Pérez", "12345678", 30, habilidades);
        Informe informe = new Informe("Este informe detalla los avances del proyecto X.", 10, "Laura Gómez", "Carlos Fernández");
        LibroPDF pdf = new LibroPDF("Ciencia Ficción", 320, "Isaac Asimov", "Fundación");
        curriculum.imprimir();
        informe.imprimir();
        pdf.imprimir();

    }
}
