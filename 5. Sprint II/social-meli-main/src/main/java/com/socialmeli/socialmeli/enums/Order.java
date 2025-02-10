package com.socialmeli.socialmeli.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Order {
    ASC("asc"),
    DESC("desc");

    private final String string;
}
