package com.mdaneri.concesionariap2vivo2.entity;

public class Service {

    private String date;
    private String kilometers;
    private String descriptions;

    public Service(String date, String kilometers, String descriptions) {
        this.date = date;
        this.kilometers = kilometers;
        this.descriptions = descriptions;
    }

    public String getDate() {
        return date;
    }

    public String getKilometers() {
        return kilometers;
    }

    public String getDescriptions() {
        return descriptions;
    }
}
