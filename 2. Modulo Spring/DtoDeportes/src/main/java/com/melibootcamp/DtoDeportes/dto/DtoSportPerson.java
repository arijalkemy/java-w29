package com.melibootcamp.DtoDeportes.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

 @Data
public class DtoSportPerson {
    private String name;
    private String lastName;
    private List<String> sport;

     public DtoSportPerson(String name, String lastName, List<String> sport) {
         this.name = name;
         this.lastName = lastName;
         this.sport = sport;
     }

     @Override
    public String toString() {
        return "DtoSportPerson{" +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", sport='" + sport + '\'' +
                '}';
    }
}
