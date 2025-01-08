package ejercicio3;

public class Vaca extends Animal implements Herbivoro {
  public void sonido() {
    System.out.println("muuu");
  }

  public void comer() {
    this.comerHierba();
  }
}
