package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.socialmeli.socialmeli.dto.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonPropertyOrder({"user_id", "post_id"})
public class PostIdDto {
    @JsonProperty("user_id")
    private Integer userId;

    @JsonProperty("post_id")
    private Integer id;

    private LocalDate date;

    private ProductDto product;

    private Integer category;

    private Double price;
}
