package com.project.be_java_hisp_w29_g10.dto.response;

import lombok.Data;

@Data
public class PromoPostCountDto {
    private Long user_id;
    private String user_name;
    private Long promo_products_count;
}
