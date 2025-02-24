package com.mercadolibre.bootcamp.showroom.dto;

public class GarmentDetailsDTO {

    private Integer amount;
    private Double price;

    public GarmentDetailsDTO(Integer amount, Double price) {
        this.amount = amount;
        this.price = price;
    }

    public GarmentDetailsDTO() {}

    public Integer getAmount() {
        return amount;
    }

    public Double getPrice() {
        return price;
    }

}
