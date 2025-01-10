public class MainEjercicio3 {
    public static void main(String[] args) {
        Animal miPerro = new Perro();
        Animal miGato = new Gato();
        Animal miVaca = new Vaca();
        miPerro.emitirSonido();
        miGato.emitirSonido();
        miVaca.emitirSonido();
        comerAnimal(miPerro);
        comerAnimal(miGato);
        comerAnimal(miVaca);
    }
    public static void comerAnimal(Animal animal) {
        if (animal instanceof Carnivoro) {
            ((Carnivoro) animal).comerCarne();
        } else if (animal instanceof Herbivoro) {
            ((Herbivoro) animal).comerHierba();
        } else {
            System.out.println("Este animal no tiene hábitos alimenticios definidos.");
        }
    }
}
