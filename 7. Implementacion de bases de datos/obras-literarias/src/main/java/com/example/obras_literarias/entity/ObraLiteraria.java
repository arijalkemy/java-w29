package com.example.obras_literarias.entity;

import com.example.obras_literarias.dto.ObraLiterariaRequestDto;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "bibloteca")
public class ObraLiteraria {

    private String id;
    @JsonProperty("nombre")
    private String nombre;
    @JsonProperty("autor")
    private String autor;
    @JsonProperty("cantidadDePaginas")
    private Integer cantidadDePaginas;
    @JsonProperty("editorial")
    private String editorial;
    @JsonProperty("year")
    private Integer year;


    public ObraLiteraria(ObraLiterariaRequestDto request) {
        this.nombre = request.getNombre();
        this.autor = request.getAutor();
        this.cantidadDePaginas = request.getCantidadDePaginas();
        this.editorial = request.getEditorial();
        this.year = request.getYear();
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public Integer getCantidadDePaginas() {
        return cantidadDePaginas;
    }

    public void setCantidadDePaginas(Integer cantidadDePaginas) {
        this.cantidadDePaginas = cantidadDePaginas;
    }

    public String getEditorial() {
        return editorial;
    }

    public void setEditorial(String editorial) {
        this.editorial = editorial;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}
