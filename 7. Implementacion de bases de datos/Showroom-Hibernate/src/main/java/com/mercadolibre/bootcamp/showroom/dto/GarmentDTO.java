package com.mercadolibre.bootcamp.showroom.dto;

public class GarmentDTO {

    private String name;
    private String type;
    private String brand;
    private String color;
    private Integer size;

    private GarmentDetailsDTO detailsDTO;

    public GarmentDTO(String name, String type, String brand, String color, Integer size, GarmentDetailsDTO detailsDTO) {
        this.name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.size = size;
        this.detailsDTO = detailsDTO;
    }

    public GarmentDTO() {}

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public String getBrand() {
        return brand;
    }

    public String getColor() {
        return color;
    }

    public Integer getSize() {
        return size;
    }

    public GarmentDetailsDTO getDetailsDTO() {
        return detailsDTO;
    }

    public void setDetailsDTO(GarmentDetailsDTO detailsDTO) {
        this.detailsDTO = detailsDTO;
    }
}
