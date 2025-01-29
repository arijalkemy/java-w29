package com.links.links.Dto;

public class LinkDto {
    private Integer id;
    private String url;
    private Integer counter;

    public LinkDto(Integer id, String url, Integer counter) {
        this.id = id;
        this.url = url;
        this.counter = counter;
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

    public Integer getCounter() {
        return counter;
    }

    public void setCounter(Integer counter) {
        this.counter = counter;
    }
}
