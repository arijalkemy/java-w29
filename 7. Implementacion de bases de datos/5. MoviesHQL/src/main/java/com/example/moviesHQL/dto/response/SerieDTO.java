package com.example.moviesHQL.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SerieDTO {
    private Integer id;
    private String title;
    private LocalDate releaseDate;
    private LocalDate endDate;
}
