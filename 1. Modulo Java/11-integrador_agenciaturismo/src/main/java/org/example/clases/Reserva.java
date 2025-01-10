package org.example.clases;

public class Reserva {
    private Integer id;
    private String titulo;
    private TipoReserva tipoReserva;
    private Double total;

    //constructores

    public Reserva() {
    }

    public Reserva(Integer id, String titulo, TipoReserva tipoReserva, Double total) {
        this.id = id;
        this.titulo = titulo;
        this.tipoReserva = tipoReserva;
        this.total = total;
    }

    //getters y setters

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

    public TipoReserva getTipoReserva() {
        return tipoReserva;
    }

    public void setTipoReserva(TipoReserva tipoReserva) {
        this.tipoReserva = tipoReserva;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    //to string

    @Override
    public String toString() {
        return "Reserva{" +
                "id=" + id +
                ", titulo='" + titulo + '\'' +
                ", " + tipoReserva.toString() +
                ", total=" + total +
                '}';
    }
}
