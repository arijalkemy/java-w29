package ejercicio2;

import ejercicio2.clases.Curriculum;
import ejercicio2.clases.Informe;
import ejercicio2.clases.LibroPDF;
import ejercicio2.interfaces.Imprimible;

import java.util.ArrayList;
import java.util.List;

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
