package ejercicios_extra_p1.dtos;

import ejercicios_extra_p1.entities.Dress;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DressDto {
  private String name;
  private String type;
  private String brand;
  private String color;
  private String size;
  private String amount;
  private Double price;

  public DressDto(Dress dress) {
    this.name = dress.getName();
    this.type = dress.getType();
    this.brand = dress.getBrand();
    this.color = dress.getColor();
    this.size = dress.getSize();
    this.amount = dress.getAmount();
    this.price = dress.getPrice();
  }

  public Dress toDress() {
    return new Dress(
      null,
      this.name,
      this.type,
      this.brand,
      this.color,
      this.size,
      this.amount,
      this.price
    );
  }
}
