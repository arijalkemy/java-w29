package animals;

public class Cat extends Animal implements Carnivore {
    @Override
    public void makeSound() {
        System.out.println("Miauw");
    }

    @Override
    public void eatMeat() {
        System.out.println("The cat eats meat");
    }
}
