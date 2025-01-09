//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Perro perro = new Perro();
        Vaca vaca = new Vaca();
        Gato gato = new Gato();

        perro.emitirSonido();
        perro.comerCarne();
        gato.emitirSonido();
        gato.comerCarne();
        vaca.emitirSonido();
        vaca.comerHierba();

        Animal.comerAnimal(vaca);
    }
}