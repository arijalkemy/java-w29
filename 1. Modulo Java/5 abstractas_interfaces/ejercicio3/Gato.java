package ejercicio3;

public class Gato extends Animal implements Carnivoro {
  public void sonido() {
    System.out.println("miau");
  }

  public void comer() {
    this.comerCarne();
  }  
}
