package com.meli.empleados.domain;

import jakarta.persistence.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "blog")
public class Empleado {
    @Id
    private Integer id;
    private String nombre;
    private String apellido;
    private Integer edad;
    private String ciudad;
    private String departamento;
}
