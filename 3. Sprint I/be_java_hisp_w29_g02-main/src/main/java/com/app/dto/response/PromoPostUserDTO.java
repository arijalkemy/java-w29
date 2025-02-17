package com.app.dto.response;

import java.util.List;

// US 0012
public class PromoPostUserDTO {

    private Integer user_id;
    private String user_name;
    private List<PostsWithProductDTO> posts;

    public PromoPostUserDTO() {
    }

    public PromoPostUserDTO(Integer user_id, String user_name, List<PostsWithProductDTO> posts) {
        this.user_id = user_id;
        this.user_name = user_name;
        this.posts = posts;
    }

    public Integer getUser_id() {
        return user_id;
    }

    public String getUser_name() {
        return user_name;
    }

    public List<PostsWithProductDTO> getPosts() {
        return posts;
    }

    public void setPost(List<PostsWithProductDTO> posts) {
        this.posts = posts;
    }
}
