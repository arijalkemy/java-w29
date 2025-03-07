package com.bootcampW22.EjercicioGlobal.utils;

import com.bootcampW22.EjercicioGlobal.entity.Vehicle;
import com.github.javafaker.Faker;

import java.util.Random;

public class VehicleBuilder {
    private Long id;
    private String brand;
    private String model;
    private String registration;
    private String color;
    private int year;
    private String max_speed;
    private int passengers;
    private String fuel_type;
    private String transmission;
    private double height;
    private double width;
    private double weight;

    public VehicleBuilder() {
        Faker faker = new Faker();
        Random random = new Random();
        this.id = faker.number().randomNumber();
        this.brand = faker.company().name();
        this.model = faker.options().option("Fiero", "Mustang", "Civic", "Camaro", "Corolla");
        this.registration = faker.bothify("???-####");
        this.color = faker.color().name();
        this.year = 1980 + random.nextInt(45);
        this.max_speed = String.valueOf(random.nextInt(200) + 50);
        this.passengers = random.nextInt(5) + 1;
        this.fuel_type = faker.options().option("gasoline", "diesel", "electric", "hybrid");
        this.transmission = faker.options().option("manual", "automatic", "semi-automatic");
        this.height = 100 + random.nextDouble() * 50;
        this.width = 150 + random.nextDouble() * 150;
        this.weight = 200 + random.nextDouble() * 1000;
    }

    public VehicleBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public VehicleBuilder setYear(int year) {
        this.year = year;
        return this;
    }

    public VehicleBuilder setColor(String color) {
        this.color = color;
        return this;
    }

    public VehicleBuilder setMaxSpeed(String max_speed) {
        this.max_speed = max_speed;
        return this;
    }

    public VehicleBuilder setPassengers(int passengers) {
        this.passengers = passengers;
        return this;
    }

    public VehicleBuilder setHeight(double height) {
        this.height = height;
        return this;
    }

    public VehicleBuilder setWidth(double width) {
        this.width = width;
        return this;
    }

    public VehicleBuilder setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Vehicle build() {
        Vehicle vehicle = new Vehicle();
        vehicle.setId(this.id);
        vehicle.setBrand(this.brand);
        vehicle.setModel(this.model);
        vehicle.setRegistration(this.registration);
        vehicle.setColor(this.color);
        vehicle.setYear(this.year);
        vehicle.setMax_speed(this.max_speed);
        vehicle.setPassengers(this.passengers);
        vehicle.setFuel_type(this.fuel_type);
        vehicle.setTransmission(this.transmission);
        vehicle.setHeight(this.height);
        vehicle.setWidth(this.width);
        vehicle.setWeight(this.weight);
        return vehicle;
    }
}
