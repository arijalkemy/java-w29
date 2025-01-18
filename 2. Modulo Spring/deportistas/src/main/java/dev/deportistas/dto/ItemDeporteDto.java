package dev.deportistas.dto;

public class ItemDeporteDto {

    private String name;

    public ItemDeporteDto(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
