package procesador;

import java.util.ArrayList;

public class Curriculum implements Imprimible {
    private String nombre;
    private String apellido;
    private String telefono;
    private String correo;
    private ArrayList<String> habilidades;

    public Curriculum(String nombre, String apellido, String telefono, String correo, ArrayList<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.telefono = telefono;
        this.correo = correo;
        this.habilidades = habilidades;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public ArrayList getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ArrayList habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre: " + getNombre());
        System.out.println("Apellido: " + getApellido());
        System.out.println("Telefono: " + getTelefono());
        System.out.println("Correo: " + getCorreo());
        System.out.println("Habilidades: " + getHabilidades());
    }
}
