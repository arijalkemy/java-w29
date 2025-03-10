package com.bootcamp.linktracker.model;


public class Link {
    private String id;
    private String url;
    private Integer visits;

    public void setId(String id) {
        this.id = id;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    public String getId() {
        return id;
    }

    public String getUrl() {
        return url;
    }

    public Integer getVisits() {
        return visits;
    }
}
