package org.example.ej_deportistas.Dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.ej_deportistas.Models.Persona;

@Data
@NoArgsConstructor
public class DeportistaDto {
    private String nombre;
    private String apellido;
    private String nombreDeporte;

    // Constructor que acepta los tres parámetros
    public DeportistaDto(String nombre, String apellido, String nombreDeporte) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nombreDeporte = nombreDeporte;
    }

    // Getters
    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    // Método estático para convertir una Persona en DeportistaDto
    public static DeportistaDto toDto(Persona persona) {
        return new DeportistaDto(
                persona.getNombre(),
                persona.getApellido(),
                persona.getDeporte().getNombre() // Asumiendo que esto no lanza una excepción
        );
    }
}
