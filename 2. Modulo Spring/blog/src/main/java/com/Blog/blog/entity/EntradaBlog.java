package com.Blog.blog.entity;

public class EntradaBlog {
    private Integer id;
    private String titulo;
    private String nomAutor;
    private String fechaPublicacion;

    public EntradaBlog(Integer id, String titulo, String nomAutor, String fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nomAutor = nomAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getNomAutor() {
        return nomAutor;
    }

    public void setNomAutor(String nomAutor) {
        this.nomAutor = nomAutor;
    }

    public String getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(String fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
