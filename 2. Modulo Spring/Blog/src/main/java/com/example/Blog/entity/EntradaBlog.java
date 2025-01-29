package com.example.Blog.entity;

import java.util.Date;
import java.util.UUID;

public class EntradaBlog {
    private UUID idBlog;
    private String tituloBlog;
    private String nombreAutor;
    private Date fechaPublicacion;

    public EntradaBlog(String tituloBlog, String nombreAutor, Date fechaPublicacion) {
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getTituloBlog() {
        return tituloBlog;
    }

    public void setTituloBlog(String tituloBlog) {
        this.tituloBlog = tituloBlog;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    @Override
    public String toString() {
        return "EntradaBlog{" +
                "idBlog=" + idBlog +
                ", tituloBlog='" + tituloBlog + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}
