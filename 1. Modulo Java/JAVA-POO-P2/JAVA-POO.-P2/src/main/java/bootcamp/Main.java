package bootcamp;

public class Main {
    public static void main(String[] args) {

        Animal perro = new Perro("Perro", "Tito");
        perro.mostrarEspecie();
        perro.hacerSonido();

        Animal gato = new Gato("Gato", "Poker");
        gato.mostrarEspecie();
        gato.hacerSonido();

        Animal animal = perro; //toma todas las funcionalidades de perro
        animal.mostrarEspecie();
        animal.hacerSonido();
    }
}
