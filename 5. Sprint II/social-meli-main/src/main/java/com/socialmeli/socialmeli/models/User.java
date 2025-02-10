package com.socialmeli.socialmeli.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
public class User {
    private Integer id;

    private String name;

    private Boolean isSeller;
}
