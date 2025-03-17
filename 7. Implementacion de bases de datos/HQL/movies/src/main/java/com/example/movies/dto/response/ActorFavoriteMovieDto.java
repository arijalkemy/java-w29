package com.example.movies.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActorFavoriteMovieDto {
    private String firstName;

    private String lastName;

    private String movie;
}
