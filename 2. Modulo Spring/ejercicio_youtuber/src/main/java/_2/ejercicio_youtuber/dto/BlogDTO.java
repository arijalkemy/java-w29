package _2.ejercicio_youtuber.dto;

import java.util.Date;

public class BlogDTO {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;

    public BlogDTO() {

    }

    public BlogDTO(Long id, String titulo, String nombreAutor, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    //getters y setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
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

    //to string

    @Override
    public String toString() {
        return "BlogDTO{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}

