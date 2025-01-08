package ejercicio2;

import java.lang.reflect.Field;
import java.util.Arrays;

public abstract class Document {
  public String toString() {
    Field fields[] = this.getClass().getDeclaredFields();
    StringBuilder result = new StringBuilder();
    result.append(this.getClass().getSimpleName() + ":\n");
    Arrays.stream(fields).forEach(field -> {
      field.setAccessible(true);
      try{
        result.append('\t'+field.getName() + ": " + field.get(this)+'\n');
      } catch (IllegalAccessException e) {
        e.printStackTrace();
      }
    });
    return result.toString();
  }
}
