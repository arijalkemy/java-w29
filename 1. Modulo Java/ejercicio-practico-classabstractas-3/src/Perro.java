public class Perro extends Animal implements Carnivoro{

    public Perro(){}

    @Override
    public void emitirSonido(){
        System.out.println("guau");
    }

    @Override
    public void comerCarne(){
        System.out.println("El perro esta comiendo carne.");
    }
}
