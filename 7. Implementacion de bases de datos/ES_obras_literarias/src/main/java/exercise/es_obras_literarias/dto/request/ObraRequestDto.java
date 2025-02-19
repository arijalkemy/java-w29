package exercise.es_obras_literarias.dto.request;

import lombok.*;

@Getter
@Setter
public class ObraRequestDto {
    private Long id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
