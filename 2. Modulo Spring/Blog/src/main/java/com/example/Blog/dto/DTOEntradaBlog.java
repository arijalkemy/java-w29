package com.example.Blog.dto;

import java.util.Date;

public class DTOEntradaBlog {
    private String tituloBlog;
    private String nombreAutor;
    private Date fechaPublicacion;

    public DTOEntradaBlog(String tituloBlog, String nombreAutor, Date fechaPublicacion) {
        this.tituloBlog = tituloBlog;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }
}
