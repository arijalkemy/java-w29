public class Vaca extends Animal implements Comer{
    @Override
    public void emitirSonido() {
        System.out.println("Muuuuu");
    }

    @Override
    public void comer() {
        comerHierbas();
    }
}
