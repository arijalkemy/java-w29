import interfaces.Carnivoro;
import interfaces.Herviboro;
import models.Animal;
import models.Gato;
import models.Perro;
import models.Vaca;

public class Main {
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herviboro) {
            ((Herviboro) animal).comerHierba();
        }
    }
    public static void main(String[] args) {

        Gato gato = new Gato();
        Vaca vaca = new Vaca();
        Perro perro = new Perro();

        comerAnimal(gato);
        gato.emitirSonido();
        comerAnimal(vaca);
        vaca.emitirSonido();
        comerAnimal(perro);
        perro.emitirSonido();
    }
}