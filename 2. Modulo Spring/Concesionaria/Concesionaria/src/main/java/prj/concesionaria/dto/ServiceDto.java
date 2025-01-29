package prj.concesionaria.dto;

import java.time.LocalDate;

public class ServiceDto {

    private LocalDate date;
    private Long kilometers;
    private String decription;

    public ServiceDto(LocalDate date, Long kilometers, String decription) {
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
