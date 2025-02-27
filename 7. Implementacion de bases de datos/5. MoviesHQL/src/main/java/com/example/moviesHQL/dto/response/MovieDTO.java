package com.example.moviesHQL.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private Integer id;
    private String title;
    private Double rating;
    private Integer awards;
    private LocalDate releaseDate;
    private Integer length;
}
