package ejerciciopractico4.movies.ejercicio_practico_4.movies.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Data
@Getter @Setter
public class MoviesDto {
    private Long id;
    private String title;
    private Double rating;
    private Integer awards;
    private Integer length;
    @JsonProperty("release_date")
    private LocalDate releaseDate;

    public MoviesDto(Long id, String title, Double rating, Integer awards, Integer length, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.awards = awards;
        this.length = length;
        this.releaseDate = releaseDate;
    }

    public MoviesDto() {
    }
}
