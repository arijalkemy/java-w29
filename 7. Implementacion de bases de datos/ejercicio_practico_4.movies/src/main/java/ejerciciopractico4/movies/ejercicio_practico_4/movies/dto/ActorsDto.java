package ejerciciopractico4.movies.ejercicio_practico_4.movies.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter @Setter
public class ActorsDto {
    private Long id;
    private String firstName;
    private String lastName;
    private Double rating;

    public ActorsDto(Long id, String firstName, String lastName, Double rating) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.rating = rating;
    }

    public ActorsDto() {
    }
}
