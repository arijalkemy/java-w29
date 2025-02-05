package sprint1.be_java_hisp_w29_g9.dtos.products.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class ProductDTO {
  private Integer product_id;
  private String product_name;
  private String type;
  private String brand;
  private String color;
  private String notes;
}
