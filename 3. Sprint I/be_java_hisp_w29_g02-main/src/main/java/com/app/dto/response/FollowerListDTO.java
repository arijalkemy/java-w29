package com.app.dto.response;

import java.util.List;

//US 0003 US 0008
public class FollowerListDTO {
    private final Integer user_id;
    private final String user_name;
    private final List<UserDTO> followers;

    public FollowerListDTO(Integer user_id, String user_name, List<UserDTO> followed) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers = followed;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public List<UserDTO> getFollowers() {
        return followers;
    }
}
