package com.api.linkTraker.entity;

public class Link {

    private String id;
    private String url;
    private String password;
    private Integer count;

    public Link() {}

    public Link(String id, String url, String password, Integer count) {
        this.id = id;
        this.url = url;
        this.password = password;
        this.count = count;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

}