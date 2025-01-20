package animals;

public class Cow extends Animal implements Herbivore {
    @Override
    public void makeSound() {
        System.out.println("Muu");
    }

    @Override
    public void eatGrass() {
        System.out.println("Cow eats Grass");
    }
}
