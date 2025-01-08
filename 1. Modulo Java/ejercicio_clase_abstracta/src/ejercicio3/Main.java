package ejercicio3;

import ejercicio3.clases.Animal;
import ejercicio3.clases.Gato;
import ejercicio3.clases.Perro;
import ejercicio3.clases.Vaca;

public class Main {
    public static void main(String[] args) {

        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.emitirSonido();
        perro.emitirSonido();
        vaca.emitirSonido();

        gato.comerCarne();
        perro.comerCarne();
        vaca.comerHierba();

        comerAnimal(gato);
        comerAnimal(perro);
        comerAnimal(vaca);

    }

    public static void comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            ((Gato) animal).comerCarne();
            System.out.println("Come el gato");
        } else if (animal instanceof Perro) {
            ((Perro) animal).comerCarne();
            System.out.println("Come el perro");
        } else if (animal instanceof Vaca) {
            ((Vaca) animal).comerHierba();
            System.out.println("Come la vaca");
        } else {
            System.out.println("nadie come");
        }

    }
}
