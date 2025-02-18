package com.example.obrasliterarias.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Document(indexName = "obras")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiterallyWork {
    @Id
    private String id;
    private String name;
    private int quantityPages, year;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Author author;
    @Field(type = FieldType.Nested, includeInParent = true)
    private Editorial editorial;
}
