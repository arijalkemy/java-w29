package com.example.ejercicioextra1.entity.es;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "prendas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PrendaDocument {

    @Id
    private Long id;
    private String nombre;
    private String tipo;
    private String marca;
    private String color;
    private String talle;
    private Integer cantidad;
    private Double precioVenta;
    private Long ventaId;
}
