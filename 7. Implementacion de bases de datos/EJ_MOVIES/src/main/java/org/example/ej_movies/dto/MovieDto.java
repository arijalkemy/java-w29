package org.example.ej_movies.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieDto {
    private LocalDateTime createdAt;

    private String title;

    private Double rating;

    private Integer awards;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    private Integer length;

}
