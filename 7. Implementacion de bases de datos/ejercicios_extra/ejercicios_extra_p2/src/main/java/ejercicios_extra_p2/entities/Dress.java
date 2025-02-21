package ejercicios_extra_p2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dress {
  private String name;
  private String type;
  private String brand;
  private String color;
  private String size;
  private String amount;
  private Double price;
}
