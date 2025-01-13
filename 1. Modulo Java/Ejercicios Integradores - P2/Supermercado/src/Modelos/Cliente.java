package Modelos;

public class Cliente {
    private String dni;
    private String nombre;
    private String apellido;

    public Cliente(String dni, String nombre, String apellido) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    @Override
    public String toString() {
        return "datos de cliente:\n" +
                "dni: " + dni + '\n' +
                "nombre: " + nombre + '\n' +
                "apellido: " + apellido + '\n';
    }
}
