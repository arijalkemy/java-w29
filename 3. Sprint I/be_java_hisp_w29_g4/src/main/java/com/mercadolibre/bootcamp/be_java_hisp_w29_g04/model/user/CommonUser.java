package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CommonUser extends User {

    private List<Integer> follow;

    public CommonUser(String username) {
        super(username);
        follow = new ArrayList<>();
    }
    public CommonUser(String username, List<Integer> follow) {
        super(username);
        this.follow = follow;
    }

    @Override
    public UserTypeEnum getType() {
        return UserTypeEnum.COMMON;
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
