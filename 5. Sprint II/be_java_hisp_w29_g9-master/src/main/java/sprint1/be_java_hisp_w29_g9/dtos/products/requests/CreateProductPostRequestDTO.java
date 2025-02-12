package sprint1.be_java_hisp_w29_g9.dtos.products.requests;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import sprint1.be_java_hisp_w29_g9.dtos.products.responses.ProductDTO;

@Getter
public class CreateProductPostRequestDTO {

    @NotNull(message = "{validation.id.not_null}")
    @Positive(message = "{validation.id.positive}")
    private Integer user_id;

    @NotEmpty(message = "{validation.date.not_empty}")
    private String date;

    @Valid
    private ProductDTO product;

    @NotNull(message = "{validation.not_empty}")
    private Integer category;

    @NotNull(message = "{validation.not_empty}")
    @Max(value = 10000000, message = "{validation.product.max}")
    private Double price;
}
