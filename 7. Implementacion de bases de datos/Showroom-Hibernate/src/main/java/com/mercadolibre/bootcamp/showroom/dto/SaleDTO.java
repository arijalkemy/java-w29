package com.mercadolibre.bootcamp.showroom.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.util.List;

public class SaleDTO {

    private Long id;

    @JsonProperty("sold_on")
    private LocalDate soldOn;

    @JsonProperty("means_of_payment")
    private String meansOfpayment;

    private Double total;
    private List<GarmentDTO> garmentList;

    public SaleDTO() {}

    public SaleDTO(Long id, LocalDate soldOn, String meansOfpayment, Double total, List<GarmentDTO> garmentList) {
        this.id = id;
        this.soldOn = soldOn;
        this.meansOfpayment = meansOfpayment;
        this.total = total;
        this.garmentList = garmentList;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getSoldOn() {
        return soldOn;
    }

    public String getMeansOfpayment() {
        return meansOfpayment;
    }

    public Double getTotal() {
        return total;
    }

    public List<GarmentDTO> getGarmentList() {
        return garmentList;
    }
}


