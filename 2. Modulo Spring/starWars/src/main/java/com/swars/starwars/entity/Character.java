package com.swars.starwars.entity;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Character {
    public String name;
    public int height;
    public int mass;
    public String hairColor;
    public String skinColor;
    public String eyeColor;
    public String birthYear;
    public String gender;
    public String homeworld;
    public String species;
}
