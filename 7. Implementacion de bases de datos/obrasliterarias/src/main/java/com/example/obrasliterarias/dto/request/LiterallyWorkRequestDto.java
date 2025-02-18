package com.example.obrasliterarias.dto.request;

import com.example.obrasliterarias.model.Author;
import com.example.obrasliterarias.model.Editorial;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class LiterallyWorkRequestDto {
    private Long id;
    private String name;
    private Integer quantityPages, year;
    private Author author;
    private Editorial editorial;
}
