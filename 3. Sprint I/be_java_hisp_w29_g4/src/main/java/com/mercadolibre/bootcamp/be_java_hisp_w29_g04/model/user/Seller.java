package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Setter
@Getter
public class Seller extends User {

    private List<Integer> follow;

    public Seller(String username) {
        super(username);
        follow = new ArrayList<>();
    }

    public Seller(String username, List<Integer> follow) {
        super(username);
        this.follow = follow;
    }

    @Override
    public UserTypeEnum getType() {
        return UserTypeEnum.SELLER;
    }

    @Override
    public void addFollow(Integer id) {
        follow.add(id);
    }

    @Override
    public void removeFollow(Integer id) {
        follow.remove(id);
    }
}
