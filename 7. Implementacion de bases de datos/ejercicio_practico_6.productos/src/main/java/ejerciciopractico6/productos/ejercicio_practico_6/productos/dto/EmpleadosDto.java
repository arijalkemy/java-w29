package ejerciciopractico6.productos.ejercicio_practico_6.productos.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter @Setter
public class EmpleadosDto {
    private String id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String provincia;

    public EmpleadosDto(String id, String nombre, String apellido, Integer edad, String ciudad, String provincia) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.ciudad = ciudad;
        this.provincia = provincia;
    }

    public EmpleadosDto() {
    }
}
