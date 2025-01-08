package ejercicio3;

public abstract class Animal {
  public abstract void sonido();
  public abstract void comer();
  static void comerAnimal(Animal animal) {
    animal.comer();
  }
}