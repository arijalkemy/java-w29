package sprint1.be_java_hisp_w29_g9.dtos.products.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
@Setter
public class PostDiscountDTO {
    private Integer user_id;
    private Integer post_id;
    private String date;
    private ProductDTO product;
    private String category;
    private Double price;
    private Double discount;
}
