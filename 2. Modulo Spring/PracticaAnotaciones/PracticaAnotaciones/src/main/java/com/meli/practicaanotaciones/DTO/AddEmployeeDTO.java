package com.meli.practicaanotaciones.DTO;

public class AddEmployeeDTO {
    private String name;

    public AddEmployeeDTO() {
    }

    public AddEmployeeDTO(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "AddEmployeeDTO{" +
                "name='" + name + '\'' +
                '}';
    }
}
