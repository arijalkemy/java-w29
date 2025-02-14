package com.meli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.meli.socialmeli.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProductsOfSellerDto {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("user_name")
    private String userName;

    private List<PostDto> posts;
}
