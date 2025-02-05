package com.bootcamp.be_java_hisp_w29_g3.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FollowerCountDTO {
    private Integer userId;
    private String userName;
    private Long followersCount;


}
