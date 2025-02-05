package com.bootcamp.be_java_hisp_w29_g3.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
public abstract class User {
    private Integer id;
    private String name;
}
