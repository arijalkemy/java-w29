package com.Link_Tracker.Traker.dto.response;

public class LinkResponseDto {
    private Integer id;
    private String enmascarado;
    private boolean valido;

    public String getEnmascarado() {
        return enmascarado;
    }

    public void setEnmascarado(String enmascarado) {
        this.enmascarado = enmascarado;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
