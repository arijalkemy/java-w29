package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.response;

import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.dto.PostDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class PostsBySellersFollowedDto {
    private Integer userId;
    private List<PostDto> posts;
}