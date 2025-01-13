
public class Perro extends Animal implements Carnivoro {

    @Override
    public void emitirSonido() {
        System.out.println("Guau");
    }

    @Override
    public void animalComer() {
        comerCarnivoro();
    }


}
