package prj.concesionaria.model;

import java.time.LocalDate;

public class Services {

    private LocalDate date;
    private Long kilometers;
    private String decription;

    public Services(LocalDate date, Long kilometers, String decription) {
        this.date = date;
        this.kilometers = kilometers;
        this.decription = decription;
    }

    public LocalDate getDate() {
        return date;
    }

    public Long getKilometers() {
        return kilometers;
    }

    public String getDecription() {
        return decription;
    }
}
