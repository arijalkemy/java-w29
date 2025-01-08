package ejercicio3;

public class Main {
  public static void main(String[] args) {
    Gato gato = new Gato();
    Perro perro = new Perro();
    Vaca vaca = new Vaca();
    gato.sonido();
    perro.sonido();
    vaca.sonido();
    gato.comer();
    perro.comer();
    vaca.comer();
    Animal.comerAnimal(gato);
  }
}
