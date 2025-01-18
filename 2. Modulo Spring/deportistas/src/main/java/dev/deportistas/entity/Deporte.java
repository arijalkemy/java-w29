package dev.deportistas.entity;

public class Deporte {

    private String name;
    private Integer nivel;

    public Deporte(String name, Integer nivel) {
        this.name = name;
        this.nivel = nivel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNivel() {
        return nivel;
    }

    public void setNivel(Integer nivel) {
        this.nivel = nivel;
    }
}
