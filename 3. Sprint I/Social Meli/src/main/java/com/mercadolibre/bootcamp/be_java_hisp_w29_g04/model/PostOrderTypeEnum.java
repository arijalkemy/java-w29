package com.mercadolibre.bootcamp.be_java_hisp_w29_g04.model;

import lombok.Getter;

import java.util.Comparator;

@Getter
public enum PostOrderTypeEnum {
    UNORDERED((p1, p2) -> 0),
    DATE_DESC((p1, p2) -> p2.getCreatedAt().compareTo(p1.getCreatedAt())),
    DATE_ASC((p1, p2) -> p1.getCreatedAt().compareTo(p2.getCreatedAt()));

    private final Comparator<Post> comparator;

    PostOrderTypeEnum(Comparator<Post> comparator) {
        this.comparator = comparator;
    }

}