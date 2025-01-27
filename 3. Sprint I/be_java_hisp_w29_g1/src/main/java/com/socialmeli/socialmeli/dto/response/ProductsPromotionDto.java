package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonPropertyOrder({"user_id", "user_name"})
public class ProductsPromotionDto {
    @JsonProperty("user_id")
    private Integer idUser;

    @JsonProperty("user_name")
    private String nameUser;

    private List<PostIdSaleDto> posts;
}
