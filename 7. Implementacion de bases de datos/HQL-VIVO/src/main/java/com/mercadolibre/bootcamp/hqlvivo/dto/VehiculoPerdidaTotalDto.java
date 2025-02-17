package com.mercadolibre.bootcamp.hqlvivo.dto;

import java.util.List;

public class VehiculoPerdidaTotalDto {

    private List<VehiculoPatenteModeloMarcaDto> vehiculos;
    private Double total;

    public VehiculoPerdidaTotalDto(List<VehiculoPatenteModeloMarcaDto> vehiculos, Double total) {
        this.vehiculos = vehiculos;
        this.total = total;
    }

    public VehiculoPerdidaTotalDto() {}

    public List<VehiculoPatenteModeloMarcaDto> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<VehiculoPatenteModeloMarcaDto> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
