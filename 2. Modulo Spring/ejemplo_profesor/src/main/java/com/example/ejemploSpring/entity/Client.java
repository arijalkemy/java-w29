package com.example.ejemploSpring.entity;

import lombok.*;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Client {
    private String name;
    private String lastname;
    private int age;
    private boolean married;

}
