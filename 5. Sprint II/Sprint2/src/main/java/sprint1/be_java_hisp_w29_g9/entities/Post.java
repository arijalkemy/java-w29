package sprint1.be_java_hisp_w29_g9.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Post {
    private Integer post_id;
    private String date;
    private Product product;
    private String category;
    private Double price;
    private Boolean has_promo;
    private Double discount;
}
