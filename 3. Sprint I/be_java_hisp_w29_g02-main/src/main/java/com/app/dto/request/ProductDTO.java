package com.app.dto.request;

public class ProductDTO {

    private Integer product_id;
    private String product_name;
    private String type;
    private String brand;
    private String color;
    private String notes;

    public ProductDTO(Integer id, String name, String type, String brand, String color, String notes) {
        this.product_id = id;
        this.product_name = name;
        this.type = type;
        this.brand = brand;
        this.color = color;
        this.notes = notes;
    }

    public ProductDTO() {
    }

    public Integer getProduct_id() {
        return product_id;
    }

    public void setProduct_id(Integer product_id) {
        this.product_id = product_id;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
