package com.meli.empleados.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "users")
@Data
@ToString
public class User {
    @Id
    private String id;
    private String nombre;
}
