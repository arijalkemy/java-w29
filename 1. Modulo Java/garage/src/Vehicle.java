public class Vehicle {
    private String brand;
    private String model;
    private Double price;

    public Vehicle(String marca, String modelo, Double precio) {
        this.brand = marca;
        this.model = modelo;
        this.price = precio;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Vehicle - Brand: " + brand + ", Model: " + model + ", Price: " + price + ".";
    }
}
