package com.bootcamp.be_java_hisp_w29_g3.dto.response;

import com.bootcamp.be_java_hisp_w29_g3.dto.UserDTO;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class UserFollowersDTO {
    private Integer userId;
    private String userName;
    private List<UserDTO> followers;
}

