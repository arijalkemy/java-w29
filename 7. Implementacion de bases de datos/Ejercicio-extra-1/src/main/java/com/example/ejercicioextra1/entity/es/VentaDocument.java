package com.example.ejercicioextra1.entity.es;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;


import java.time.LocalDate;

@Document(indexName = "ventas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class VentaDocument {

    @Id
    private Long id;
    private LocalDate fecha;
    private Double total;
    private String medioPago;
}
