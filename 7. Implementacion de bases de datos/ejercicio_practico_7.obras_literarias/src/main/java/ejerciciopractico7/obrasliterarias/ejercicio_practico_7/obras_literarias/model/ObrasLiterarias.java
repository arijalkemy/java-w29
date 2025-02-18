package ejerciciopractico7.obrasliterarias.ejercicio_practico_7.obras_literarias.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "obras")
public class ObrasLiterarias {
    @Id
    private String id;
    private String nombre;
    private String autor;
    private Integer cantPag;
    private String editoria;
    private Integer ano;

    public ObrasLiterarias(String id, String nombre, String autor, Integer cantPag, String editoria, Integer ano) {
        this.id = id;
        this.nombre = nombre;
        this.autor = autor;
        this.cantPag = cantPag;
        this.editoria = editoria;
        this.ano = ano;
    }

    public ObrasLiterarias() {
    }

}
