package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public abstract class User {

    private Integer userId;
    private String username;
    private static int idCounter = 1;

    public User(String username) {
        this.userId = generateId();
        this.username = username;
    }

    public abstract UserTypeEnum getType();

    public abstract List<Integer> getFollow();

    private Integer generateId() {
        return idCounter++;
    }

    public abstract void addFollow(Integer sellerId);
    public abstract void removeFollow(Integer sellerId);
}
