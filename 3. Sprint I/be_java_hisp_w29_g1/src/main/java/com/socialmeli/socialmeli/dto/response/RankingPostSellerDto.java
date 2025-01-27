package com.socialmeli.socialmeli.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RankingPostSellerDto {
    @JsonProperty("user_id")
    private Integer idUser;

    @JsonProperty("user_name")
    private  String nameUser;

    @JsonProperty("post_count")
    private  Integer postCount;
}
