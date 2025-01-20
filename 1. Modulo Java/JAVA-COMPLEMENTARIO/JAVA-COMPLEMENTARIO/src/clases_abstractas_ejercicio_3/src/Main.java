import Clases.Animal;
import Clases.Gato;
import Clases.Perro;
import Clases.Vaca;

public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        //Este método necesita un system.out.println porque devuelve un String
        System.out.println("------------ Animales consumiendo el método comerCarne()----------------");
        System.out.println(perro.comerCarne());
        System.out.println(gato.comerCarne());
        System.out.println(vaca.comerHierba());

        //En este caso no hace falta porque el método es Void y allí se encarga de tirar el System.out.println
        System.out.println("------------ Animales consumiendo el método emitirSonido()----------------");
        perro.emitirSonido();
        gato.emitirSonido();
        vaca.emitirSonido();


        System.out.println("------------ Método comerAnimal con parametro de tipo de animal-----------");
        String resultado1 = comerAnimal(perro);
        String resultado2 = comerAnimal(gato);
        String resultado3 = comerAnimal(vaca);
        System.out.println(resultado1);
        System.out.println(resultado2);
        System.out.println(resultado3);

    }
    public static String comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            return ((Gato) animal).comerCarne();
        } else if (animal instanceof Perro) {
            return ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            return ((Vaca) animal).comerHierba();
        }
        return "";
    }
}