package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ObrasLiterariasDto {
    private String id;
    private String nombre;
    private String autor;
    private Integer cantPag;
    private String editoria;
    private Integer ano;

    public ObrasLiterariasDto(String id, String nombre, String autor, Integer cantPag, String editoria, Integer ano) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.cantPag = cantPag;
        this.editoria = editoria;
        this.ano = ano;
    }

    public ObrasLiterariasDto() {
    }
}
