import classes.Animal;
import classes.Gato;
import classes.Perro;
import classes.Vaca;

public class Main {
    public static void eatAnimal(Animal animal) {
        animal.eat();
    }

    public static void main(String[] args) {
        Gato gato = new Gato();
        Perro perro = new Perro();
        Vaca vaca = new Vaca();

        gato.makeSound();
        perro.makeSound();
        vaca.makeSound();

        gato.eatMeat();
        perro.eatMeat();
        vaca.eatGrass();

        eatAnimal(gato);
        eatAnimal(perro);
        eatAnimal(vaca);
    }
}
