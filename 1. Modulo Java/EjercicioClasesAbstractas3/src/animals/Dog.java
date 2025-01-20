package animals;

public class Dog extends Animal implements Carnivore{
    @Override
    public void makeSound() {
        System.out.println("Guauu");
    }

    @Override
    public void eatMeat() {
        System.out.println("The dog eats meat");
    }
}
