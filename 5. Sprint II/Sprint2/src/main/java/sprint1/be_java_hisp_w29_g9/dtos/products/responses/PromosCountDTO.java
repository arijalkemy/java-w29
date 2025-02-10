package sprint1.be_java_hisp_w29_g9.dtos.products.responses;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public class PromosCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}