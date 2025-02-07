package com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// US 0011
@AllArgsConstructor
@NoArgsConstructor
@Data
public class PromoProductsCountDTO {
    private Integer user_id;
    private String user_name;
    private Integer promo_products_count;
}
