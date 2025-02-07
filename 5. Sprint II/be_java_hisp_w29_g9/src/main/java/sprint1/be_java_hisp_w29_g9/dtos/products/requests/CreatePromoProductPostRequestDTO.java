package sprint1.be_java_hisp_w29_g9.dtos.products.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.Getter;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductDTO;


@Getter
public class CreatePromoProductPostRequestDTO {

    @NotNull(message = "{validation.id.not_null}")
    @Min(value = 1, message = "validation.id.positive")
    private Integer user_id;

    @NotBlank(message = "{validation.date.not_empty}")
    private String date;

    @Valid
    private ProductDTO product;

    @NotNull(message = "{validation.not_empty}")
    private Integer category;

    @NotNull(message = "{validation.not_empty}")
    @DecimalMax(value = "10000000", message = "{validation.product.max}")
    private Double price;

    @NotNull(message = "{validation.not_empty}")
    private Boolean has_promo;

    @NotNull(message = "{validation.not_empty}")
    private Double discount;
}
