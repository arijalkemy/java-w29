package documentos;

import java.util.List;

public class Curriculum implements Imprimible{

    private String nombre;
    private String apellido;
    private String email;
    private List<String> habilidades;

    public Curriculum(String nombre, String apellido, String email, List<String> habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.email = email;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public String obtenerContenido() {
        String contenidoPersona =
                "Nombre: " + this.nombre + "\n" +
                "Apellido: " + this.apellido + "\n" +
                "Email: " + this.email + "\n";

        StringBuilder habilidadesPersona = new StringBuilder();
        this.habilidades.forEach(s -> habilidadesPersona.append(s + "\n"));

        return "-----------CURRICULUM-----------\n" +
                contenidoPersona +
                "Habilidades: " + "\n" +
                habilidadesPersona;
    }
}
