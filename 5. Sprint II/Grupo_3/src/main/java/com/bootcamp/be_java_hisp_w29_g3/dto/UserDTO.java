package com.bootcamp.be_java_hisp_w29_g3.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserDTO {
    private Integer userId;
    private String userName;
}
