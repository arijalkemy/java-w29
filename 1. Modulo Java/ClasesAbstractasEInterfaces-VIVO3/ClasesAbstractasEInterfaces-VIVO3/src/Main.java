import clases.Animal;
import clases.Gato;
import clases.Perro;
import clases.Vaca;

public class Main {
    public static void main(String[] args) {

        Perro perro = new Perro();
        Gato gato = new Gato();
        Vaca vaca = new Vaca();

        perro.emitirSonido();
        System.out.println(perro.comerCarne());
        gato.emitirSonido();
        System.out.println(gato.comerCarne());
        vaca.emitirSonido();
        System.out.println(vaca.comerHierba());


        String resultado1 = comerAnimal(perro);
        String resultado2 = comerAnimal(gato);
        String resultado3 = comerAnimal(vaca);
        System.out.println(resultado1);
        System.out.println(resultado2);
        System.out.println(resultado3);

    }
    //Duda ejercicio
    //downcasting upcasting
    public static String comerAnimal(Animal animal) {
        if (animal instanceof Gato) {
            return ((Gato)animal).comerCarne();
        } else if (animal instanceof Perro) {
            return ((Perro) animal).comerCarne();
        } else if (animal instanceof Vaca) {
            return ((Vaca) animal).comerHierba();
        }
        return "";
    }

}
