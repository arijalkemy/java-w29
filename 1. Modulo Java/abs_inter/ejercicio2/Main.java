package ejercicio2;

import java.util.List;

public class Main {
  public static void main(String[] args) {
    Document doc = new Curr("Juan", 25, "Developer", List.of("Java", "Python", "C++"));
    Document doc2 = new Book(200, "J.K. Rowling", "Harry Potter", "Fantasy");
    Document doc3 = new Resume("Erase una vez en un lugar de la mancha" +
    "de cuyo nombre no quiero acordarme no ha mucho tiempo que vivia un hidalgo de los de lanza en astillero"+
    "adarga antigua rocín flaco y galgo corredor una olla de algo más vaca que carnero salpicón las más noches"+
    "duelo los sábados lentejas los viernes algún palomino de añadidura los domingos consumían las tres partes de su hacienda",
    10, "Miguel de Cervantes", "Editorial Cervantes");
    System.out.println(doc);
    System.out.println(doc2);
    System.out.println(doc3);
  }
}