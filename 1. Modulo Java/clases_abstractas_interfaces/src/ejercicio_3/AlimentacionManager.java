package ejercicio_3;

public class AlimentacionManager {
    public static void comerAnimal(Animal animal) {
        if(animal instanceof Carnivoro){
            ((Carnivoro) animal).comerCarne();
        }

        if(animal instanceof Herviboro){
            ((Herviboro) animal).comerHierba();
        }
    }
}
