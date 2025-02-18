package ejerciciopractico4.movies.ejercicio_practico_4.movies.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter @Setter
public class EpisodesDto {
    private Long id;
    private String title;
    private Integer number;
    private Double rating;

    public EpisodesDto(Long id, String title, Integer number, Double rating) {
        this.id = id;
        this.title = title;
        this.number = number;
        this.rating = rating;
    }

    public EpisodesDto() {
    }
}
