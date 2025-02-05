package com.app.dto.response;

public class UserDTO {
//    @JsonProperty(value = "user_id")
    private Integer user_id;
    private String user_name;

    public UserDTO(String user_name, Integer user_id) {
        this.user_name = user_name;
        this.user_id = user_id;
    }

    public UserDTO() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }
}
