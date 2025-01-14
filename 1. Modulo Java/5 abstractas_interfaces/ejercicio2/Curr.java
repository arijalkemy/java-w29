package ejercicio2;

import java.util.ArrayList;
import java.util.List;

public class Curr extends Document {
  private String name;
  private int age;
  private String profession;
  List<String> habilities = new ArrayList<String>();

  public Curr(String name, int age, String profession, List<String> habilities) {
    this.name = name;
    this.age = age;
    this.profession = profession;
    this.habilities = habilities;
  }
}
