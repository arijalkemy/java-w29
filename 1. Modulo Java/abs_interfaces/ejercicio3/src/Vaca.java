
public class Vaca extends Animal implements Herviboro, Carnivoro{

    @Override
    public void emitirSonido() {
        System.out.println("muuuu");
    }

    @Override
    public void animalComer() {
        comerHerbivoro();
    }

}
