package com.example.links.DTOs;

public class LinkCreateDTO {
    private String url;
    private String password;
    private Integer id;

    public LinkCreateDTO(String url, String password, Integer id) {
        this.url = url;
        this.password = password;
        this.id = id;
    }

    public LinkCreateDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LinkCreateDTO(String url, String password) {
        this.url = url;
        this.password = password;
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
}
