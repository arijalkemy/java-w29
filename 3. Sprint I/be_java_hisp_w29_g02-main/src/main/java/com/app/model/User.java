package com.app.model;

import java.util.List;

public class User {

    private Integer id;
    private String name;
    private Boolean isSeller;
    private List<Integer> posts;
    private List<Integer> followers;
    private List<Integer> following;

    public User() {
    }

    public User(Integer id, String name, Boolean isSeller, List<Integer> posts, List<Integer> followers, List<Integer> following) {
        this.id = id;
        this.name = name;
        this.isSeller = isSeller;
        this.posts = posts;
        this.followers = followers;
        this.following = following;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsSeller() {
        return isSeller;
    }

    public void setIsSeller(Boolean seller) {
        isSeller = seller;
    }

    public List<Integer> getPosts() {
        return posts;
    }

    public void setPosts(List<Integer> posts) {
        this.posts = posts;
    }

    public List<Integer> getFollowers() {
        return followers;
    }

    public void setFollowers(List<Integer> followers) {
        this.followers = followers;
    }

    public List<Integer> getFollowing() {
        return following;
    }

    public void setFollowing(List<Integer> following) {
        this.following = following;
    }
}