package ejercicio3;

public class Perro extends Animal implements Carnivoro {
  public void sonido() {
    System.out.println("guau");
  }

  public void comer() {
    this.comerCarne();
  }
}