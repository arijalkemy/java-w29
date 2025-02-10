package org.melibootcamp.bonusej1.dto;

import jakarta.persistence.*;
import lombok.Data;
import org.melibootcamp.bonusej1.entity.Garment;

import java.time.LocalDate;
import java.util.List;
@Data
public class SalesDto {
    private Long id;
    private LocalDate date;
    private Double total;
    private String medioDePago;
    private List<Garment> garments;

    public SalesDto(Long id, LocalDate date, Double total, String medioDePago, List<Garment> garments) {
        this.id = id;
        this.date = date;
        this.total = total;
        this.medioDePago = medioDePago;
        this.garments = garments;
    }

    public SalesDto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public String getMedioDePago() {
        return medioDePago;
    }

    public void setMedioDePago(String medioDePago) {
        this.medioDePago = medioDePago;
    }

    public List<Garment> getGarments() {
        return garments;
    }

    public void setGarments(List<Garment> garments) {
        this.garments = garments;
    }
}
