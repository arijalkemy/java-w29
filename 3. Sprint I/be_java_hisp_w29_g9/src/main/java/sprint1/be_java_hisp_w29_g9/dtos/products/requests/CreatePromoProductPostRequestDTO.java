package sprint1.be_java_hisp_w29_g9.dtos.products.requests;

import lombok.Getter;
import sprint1.be_java_hisp_w29_g9.entities.Product;

@Getter
public class CreatePromoProductPostRequestDTO {
    private Integer user_id;
    private String date;
    private Product product;
    private Integer category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
