package com.project.be_java_hisp_w29_g10.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SellerFollowersDto {
    private Long user_id;
    private String user_name;
    private List<FollowerDto> followers;
}
