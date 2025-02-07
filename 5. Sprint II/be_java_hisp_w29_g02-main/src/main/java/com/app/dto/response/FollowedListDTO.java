package com.app.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

// US 0004 US 0009
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class FollowedListDTO {
    private Integer user_id;
    private String user_name;
    private List<UserDTO> followed;
}
