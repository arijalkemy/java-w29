package ejerciciopractico4.movies.ejercicio_practico_4.movies.dto;

import jakarta.persistence.Column;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Getter @Setter
public class SerieDto {
    private Long id;
    private String title;
}
