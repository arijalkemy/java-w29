package meli.ejercicio.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "empleado")
public class Empleado {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;
}

