package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model;


import com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model.user.User;
import lombok.Getter;

import java.util.Comparator;

@Getter
public enum UserOrderTypeEnum {
    UNORDERED((u1, u2) -> 0),
    NAME_DESC((u1, u2) -> u2.getUsername().compareTo(u1.getUsername())),
    NAME_ASC((u1, u2) -> u1.getUsername().compareTo(u2.getUsername()));

    private final Comparator<User> comparator;

    UserOrderTypeEnum(Comparator<User> comparator) {
        this.comparator = comparator;
    }

}
