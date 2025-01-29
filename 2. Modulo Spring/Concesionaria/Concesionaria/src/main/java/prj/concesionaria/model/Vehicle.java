package prj.concesionaria.model;

import java.time.LocalDate;

public class Vehicle {
    private static Integer idCount = 0;
    private Integer id;
    private Integer vehicleId;
    private String brand;
    private String model;
    private Integer manufacturingDate;
    private Integer numberOfKilometers;
    private Integer doors;
    private Double price;
    private String currency;
    private Services services ;
    private Integer countOfOwners;

    public Vehicle(Integer userId, String brand, String model, Integer manufacturingDate, Integer numberOfKilometers, Integer doors, Double price, String currency, Services services, Integer countOfOwners) {
        id = idCount++;
        this.vehicleId = id;
        this.brand = brand;
        this.model = model;
        this.manufacturingDate = manufacturingDate;
        this.numberOfKilometers = numberOfKilometers;
        this.doors = doors;
        this.price = price;
        this.currency = currency;
        this.services = services;
        this.countOfOwners = countOfOwners;
    }

    public Integer getVehicleId() {
        return vehicleId;
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getManufacturingDate() {
        return manufacturingDate;
    }

    public Integer getNumberOfKilometers() {
        return numberOfKilometers;
    }

    public Integer getDoors() {
        return doors;
    }

    public Double getPrice() {
        return price;
    }

    public String getCurrency() {
        return currency;
    }

    public Services getServices() {
        return services;
    }

    public Integer getCountOfOwners() {
        return countOfOwners;
    }
}
