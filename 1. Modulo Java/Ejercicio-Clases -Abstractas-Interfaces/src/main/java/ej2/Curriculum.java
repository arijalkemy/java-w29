package ej2;

import java.util.List;
import java.util.stream.Collectors;

public class Curriculum extends Documento {
    private String nombre;
    private String email;
    private String telefono;
    private List<String> habilidades;

    public Curriculum(String nombre, String email, String telefono, List<String> habilidades) {
        super(
                String.format("Nombre: %s, Email: %s, Telefono: %s, Habilidades: %s", nombre, email, telefono, habilidades.stream()
                        .map(h -> String.format("%n  %s", h))
                        .collect(Collectors.joining())
                ));
        this.nombre = nombre;
        this.email = email;
        this.telefono = telefono;
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println(contenido);
    }
}
