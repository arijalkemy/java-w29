package _2.ejercicio_youtuber.model;

import java.util.Date;

public class EntradaBlog {
    private Long id;
    private String titulo;
    private String nombreAutor;
    private Date fechaPublicacion;

    //constructor

    public EntradaBlog() {
    }

    public EntradaBlog(Long id, String titulo, String nombreAutor, Date fechaPublicacion) {
        this.id = id;
        this.titulo = titulo;
        this.nombreAutor = nombreAutor;
        this.fechaPublicacion = fechaPublicacion;
    }

    //Getters y setters


    public Date getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(Date fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }

    public String getNombreAutor() {
        return nombreAutor;
    }

    public void setNombreAutor(String nombreAutor) {
        this.nombreAutor = nombreAutor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    //to string

    @Override
    public String toString() {
        return "EntradaBlog{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", nombreAutor='" + nombreAutor + '\'' +
                ", fechaPublicacion=" + fechaPublicacion +
                '}';
    }
}
