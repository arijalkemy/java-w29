package sprint1.be_java_hisp_w29_g9.dtos.products.responses;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Data;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@Data
public class ProductDTO {
  @NotNull(message = "{validation.id.not_null}")
  @Positive(message = "{validation.id.positive}")
  private Integer product_id;

  @NotNull(message = "{validation.not_empty}")
  @Size(max = 40, message = "{validation.string.max}")
  private String product_name;

  @NotNull(message = "{validation.not_empty}")
  @Size(max = 15, message = "{validation.string.max}")
  @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "{validation.no_especial_characters}")
  private String type;

  @NotNull(message = "{validation.not_empty}")
  @Size(max = 25, message = "{validation.string.max}")
  @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "{validation.no_especial_characters}")
  private String brand;

  @NotNull(message = "{validation.not_empty}")
  @Size(max = 15, message = "{validation.string.max}")
  @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "{validation.no_especial_characters}")
  private String color;

  @Size(max = 80, message = "{validation.string.max}")
  @Pattern(regexp = "^[a-zA-Z0-9 ]*$", message = "{validation.no_especial_characters}")
  private String notes;
}
