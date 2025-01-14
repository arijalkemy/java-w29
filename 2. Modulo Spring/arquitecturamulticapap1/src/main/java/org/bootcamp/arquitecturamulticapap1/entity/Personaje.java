package org.bootcamp.arquitecturamulticapap1.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Personaje {

    private String name;
    private Integer height;
    private Integer mass;
    @JsonIgnore
    private String hairColor;
    @JsonIgnore
    private String skinColor;
    @JsonIgnore
    private String eyeColor;
    @JsonIgnore
    private String birthYear;
    private String gender;
    private String homeworld;
    private String species;

}
