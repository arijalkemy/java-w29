package com.meli.socialmeli.dto;

import com.meli.socialmeli.entity.Seller;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FollowedListResponseDto {
    private Integer user_id;
    private String user_name;
    private List<FollowedDto> followed;

}
