public class Main {
    public static void main(String[] args) {
        System.out.println("----------------- Animal de tipo Perro -------------");
        Animal perro = new Perro("Perro", "Tito");
        perro.mostrarEspecie();
        perro.hacerSonido();

        System.out.println("----------------- Animal de tipo Gato -------------");
        Gato gato = new Gato("Gato", "Poker");
        gato.mostrarEspecie();
        gato.hacerSonido();
    }
}