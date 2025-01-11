package Models;

import Interfaces.Imprimir;

public class Curriculum implements Imprimir {

    private String nombre;
    private String apellidos;
    private String email;
    private String telefono;
    private String[] habilidades;

    public Curriculum(String nombre, String apellidos, String email, String telefono, String[] habilidades) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.email = email;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Curriculum de la persona: ");
        System.out.println("Nombre: " + nombre + " " + apellidos);
        System.out.println("Email: " + email);
        System.out.println("Teléfono: " + telefono);
        System.out.print("Habilidades: ");
        for (String habilidad : habilidades) {
            System.out.print(habilidad + " ");
        }
        System.out.println();
    }

    @Override
    public String tipoDocumento() {
        return "Curriculum";
    }
}
