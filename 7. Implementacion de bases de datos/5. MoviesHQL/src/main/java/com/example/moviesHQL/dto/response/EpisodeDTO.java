package com.example.moviesHQL.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EpisodeDTO {
    private Integer id;
    private String title;
    private Integer number;
    private LocalDate releaseDate;
    private Double rating;
}
