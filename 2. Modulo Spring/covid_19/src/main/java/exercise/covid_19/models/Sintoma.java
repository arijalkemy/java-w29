package exercise.covid_19.models;

public class Sintoma {
    private String codigo;
    private String nombre;
    private String nivelGravedad;

    public Sintoma(String codigo, String nombre, String nivelGravedad) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.nivelGravedad = nivelGravedad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNivelGravedad() {
        return nivelGravedad;
    }

    public void setNivelGravedad(String nivelGravedad) {
        this.nivelGravedad = nivelGravedad;
    }
}
