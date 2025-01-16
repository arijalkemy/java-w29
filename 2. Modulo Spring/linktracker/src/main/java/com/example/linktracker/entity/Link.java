package com.example.linktracker.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.UUID;

@Data
public class Link {
    private  String url;
    private Integer id;
    private String password;
    private Integer visits;

    public Link(String url, Integer id, String password, Integer visits) {
        this.url = url;
        this.id = id;
        this.password = password;
        this.visits = visits;
    }

    public Link() {
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getVisits() {
        return visits;
    }

    public void setVisits(Integer visits) {
        this.visits = visits;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return Objects.equals(url, link.url) && Objects.equals(id, link.id) && Objects.equals(password, link.password) && Objects.equals(visits, link.visits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(url, id, password, visits);
    }
}
