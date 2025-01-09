public class Vaca extends Animal implements Herviboro{

    public Vaca() {}

    @Override
    public void emitirSonido(){
        System.out.println("muuu");
    }

    @Override
    public void comerHierba(){
        System.out.println("La vaca esta comiendo hierba.");
    }
}
