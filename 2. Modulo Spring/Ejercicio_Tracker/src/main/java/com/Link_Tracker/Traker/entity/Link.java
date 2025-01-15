package com.Link_Tracker.Traker.entity;

public class Link {
    private Integer id;
    private String url;
    private String enmascarado;
    private Integer contador;
    private String password;
    private boolean valido;

    public Link(Integer id, String url,String enmascarado, String password, boolean valido) {
        this.id = id;
        this.url = url;
        this.enmascarado = enmascarado;
        this.contador = 0;
        this.password = password;
        this.valido = valido;
    }

    public String getEnmascarado() {
        return enmascarado;
    }

    public void setEnmascarado(String enmascarado) {
        this.enmascarado = enmascarado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isValido() {
        return valido;
    }

    public void setValido(boolean valido) {
        this.valido = valido;
    }
}
