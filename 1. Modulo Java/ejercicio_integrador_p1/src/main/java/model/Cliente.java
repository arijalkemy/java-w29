package model;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class Cliente {
    private Integer id;
    private String nombre;
    private String apellido;
    private List<Localizador> localizadores;

    public Cliente(String nombre, String apellido) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.localizadores = new ArrayList<>();
    }

    public void addLocalizador(Localizador localizador) {
        this.localizadores.add(localizador);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", localizadores=" + localizadores +
                '}';
    }
}
