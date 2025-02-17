package com.app.dto.response;

import java.util.List;

// US 0004 US 0009
public class FollowedListDTO {
    private final Integer user_id;
    private final String user_name;
    private final List<UserDTO> followed;

    public FollowedListDTO(Integer user_id, String user_name, List<UserDTO> followed) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followed = followed;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public List<UserDTO> getFollowed() {
        return followed;
    }
}
