package com.bootcamp.be_java_hisp_w29_g3.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

import java.util.List;

@SuperBuilder(toBuilder = true)
@Getter
@Setter
public class Seller extends User {
    private List<Post> posts;
}
