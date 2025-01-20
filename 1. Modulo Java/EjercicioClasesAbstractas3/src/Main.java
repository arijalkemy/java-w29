import animals.Cat;
import animals.Cow;
import animals.Dog;

public class Main {
    public static void main(String[] args) {
        System.out.println("Animas behavior examples\n");
        Cow cow = new Cow();
        Cat cat = new Cat();
        Dog dog = new Dog();

        System.out.println("Cow behavior:");
        cow.makeSound();
        cow.eatGrass();
        System.out.println("\n");

        System.out.println("Cat behavior:");
        cat.makeSound();
        cat.eatMeat();
        System.out.println("\n");

        System.out.println("Dog behavior:");
        dog.makeSound();
        dog.eatMeat();
        System.out.println("\n");

    }
}