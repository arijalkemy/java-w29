package com.bootcamp.be_java_hisp_w29_g07.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Represents the response when requesting the number of followers of a seller
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SellerFollowerCountDTO {
    /**
     * The unique identifier for the user.
     */
    private Integer user_id;
    /**
     * The username of the user.
     */
    private String user_name;
    /**
     * User followers count
     */
    private Long followers_count;
}
