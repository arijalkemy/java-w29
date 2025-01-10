package models;

public class Cliente {
    private Integer id;
    private String nombre;


    public Cliente(Integer id, String nombre) {
        this.id = id;
        this.nombre = nombre;
    }

    public Cliente(String nombre) {
        this.nombre = nombre;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                '}';
    }
}
