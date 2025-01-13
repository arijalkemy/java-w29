package com.exercise2;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    /**
     * Says hello to the world.
     * 
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        List<String> skills = new ArrayList<String>();
        skills.add("Desarrollo");
        skills.add("Planeación");
        skills.add("Liderazgo");
        Documento curriculum = new Curriculum("Sergio", "Developer", skills);

        Documento libro = new Libro(250, "Paulini", "Eragon", "Fantasia");

        Documento informe = new Informe("testing text", 1, "tester", "admin");

        Imprimible.imprimir(curriculum);

        Imprimible.imprimir(libro);

        Imprimible.imprimir(informe);
    }
}
