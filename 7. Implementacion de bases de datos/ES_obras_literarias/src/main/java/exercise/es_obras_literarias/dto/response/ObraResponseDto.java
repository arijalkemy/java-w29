package exercise.es_obras_literarias.dto.response;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class ObraResponseDto {
    private Long id;
    private String nombre;
    private String autor;
    private Integer cantidadPaginas;
    private String editorial;
    private Integer anioPublicacion;
}
