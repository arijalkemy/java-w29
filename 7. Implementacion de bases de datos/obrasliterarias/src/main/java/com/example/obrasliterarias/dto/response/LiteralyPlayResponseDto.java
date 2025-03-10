package com.example.obrasliterarias.dto.response;

import com.example.obrasliterarias.model.Author;
import com.example.obrasliterarias.model.Editorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LiteralyPlayResponseDto {
    private Long id;
    private String name;
    private int quantityPages, year;
    private Author author;
    private Editorial editorial;
}
