package com.example.linktracker.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Link {
    private Integer id;
    private String url;
    private Boolean valid;
    private Integer visitCounter;
    private String password;

    public Link(Integer id, String url, String password){
        this.id = id;
        this.url = url;
        this.valid = true;
        this.visitCounter = 0;
        this.password = password;
    }
}
