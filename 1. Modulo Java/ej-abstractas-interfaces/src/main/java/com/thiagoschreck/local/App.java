package com.thiagoschreck.local;

import com.thiagoschreck.local.animales.Animal;
import com.thiagoschreck.local.animales.Carnivoro;
import com.thiagoschreck.local.animales.Herbivoro;
import com.thiagoschreck.local.animales.Perro;
import com.thiagoschreck.local.documentos.Curriculum;
import com.thiagoschreck.local.documentos.Imprimible;
import com.thiagoschreck.local.documentos.Informe;
import com.thiagoschreck.local.documentos.LibroEnPDF;

import java.util.List;

public class App {
    public static void main(String[] args) {

        Imprimible libro = new LibroEnPDF(118, "Roy Berocay", "El Sapo Ruperto", "Aventura");
        Imprimible curriculum = new Curriculum("Johnny", "Test", "1.234.567-8", 19, List.of("Ofimática", "Inglés", "Pedagogía"));
        Imprimible informe = new Informe("Lorem ipsum dolor sit amet", 95, "Lorena Ipsum", "Johnny Test");

        libro.imprimir();
        curriculum.imprimir();
        informe.imprimir();

        Animal mascota = new Perro();
        mascota.emitirSonido();
        alimentarAnimal(mascota);
    }

    private static void alimentarAnimal(Animal animal) {
        if (animal instanceof Herbivoro) {
            ((Herbivoro) animal).comerHierba();
        }
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        }
    }
}
