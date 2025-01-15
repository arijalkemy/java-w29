package com.example.links.DTOs;

public class LinkDTO {
    private Integer id;
    private String url;
    private Integer redirectCount;
    private String password;

    public LinkDTO(Integer id, String url, Integer redirectCount, String password) {
        this.id = id;
        this.url = url;
        this.redirectCount = redirectCount;
        this.password = password;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getRedirectCount() {
        return redirectCount;
    }

    public void setRedirectCount(Integer redirectCount) {
        this.redirectCount = redirectCount;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
