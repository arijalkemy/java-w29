package ejerciciopractico6.productos.ejercicio_practico_6.productos.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Getter @Setter
@Document(indexName = "employeed")
public class Empleados {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;

    public Empleados(String id, String nombre, String apellido, Integer edad, String ciudad, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public Empleados() {
    }
}
