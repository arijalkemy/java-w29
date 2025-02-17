package meli.ejercicio.domain;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(indexName = "empleado")
public class ObraLiteraria {
    @Id
    private String id;
    private String nombre;
    private String apellido;
    private int edad;
    private String ciudad;
    private String provincia;
}
