package com.app.dto.response;

// US 0002
public class FollowersCountDTO {

    private Integer user_id;

    private String user_name;

    private Integer followers_count;

    public FollowersCountDTO(Integer user_id, String user_name, Integer followers_count) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.followers_count = followers_count;
    }

    public FollowersCountDTO() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    public Integer getFollowers_count() {
        return followers_count;
    }

    public void setFollowers_count(Integer followers_count) {
        this.followers_count = followers_count;
    }
}
