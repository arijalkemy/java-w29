package com.app.dto.response;

import com.app.dto.request.PostDTO;

import java.util.List;

//US 0006:
public class PostListDTO {

    private Integer user_id;

    private List<PostDTO> posts;

    public PostListDTO(List<PostDTO> posts, Integer user_id) {
        this.posts = posts;
        this.user_id = user_id;
    }

    public PostListDTO() {
    }

    public Integer getUser_id() {
        return user_id;
    }

    public void setUser_id(Integer user_id) {
        this.user_id = user_id;
    }

    public List<PostDTO> getPosts() {
        return posts;
    }

    public void setPosts(List<PostDTO> posts) {
        this.posts = posts;
    }
}
