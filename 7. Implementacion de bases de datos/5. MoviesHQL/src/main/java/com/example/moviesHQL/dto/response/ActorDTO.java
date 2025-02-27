package com.example.moviesHQL.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActorDTO {
    private Integer id;
    private String firstName;
    private String lastName;
    private Double rating;
}
