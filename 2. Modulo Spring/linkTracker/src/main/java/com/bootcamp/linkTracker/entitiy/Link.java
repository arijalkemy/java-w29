package com.bootcamp.linkTracker.entitiy;

import lombok.Data;

@Data
public class Link {
    private Integer id;
    private String link;
    private Integer uses;
    private Boolean valid;
    private String password;

    public Link(String link) {
        this.link = link;
        this.uses = 0;
        this.valid = true;
        this.password = "12345";
    }
}
