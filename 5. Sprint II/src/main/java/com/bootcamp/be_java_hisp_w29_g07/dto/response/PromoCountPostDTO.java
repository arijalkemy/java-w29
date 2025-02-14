package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the response when searching for discounted publications
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class PromoCountPostDTO {
    /**
     * The ID of the user who created the post.
     */
    private Integer user_id;
    /**
     * The first name of the user.
     */
    private String user_name;
    /**
     * Count of products with promotion
     */
    private Integer promo_products_count;
}
