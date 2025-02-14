package com.meli.socialmeli.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerDto {
    private Integer user_id;

    private String user_name;

    private Integer followers_count;

}
