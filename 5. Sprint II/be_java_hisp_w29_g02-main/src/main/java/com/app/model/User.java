package com.app.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    private Integer id;
    private String name;
    private Boolean isSeller;
    private List<Integer> posts;
    private List<Integer> followers;
    private List<Integer> following;
}