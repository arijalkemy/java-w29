package org.melibootcamp.links.entity;

public class Link {
    private Long id;
    private Integer contador;
    private String url;
    private String contraseña;

    public Link(String url, String contraseña) {
        this.contador = 0;
        this.url = url;
        this.contraseña = contraseña;
    }

    public Link(String url) {
        this.url = url;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }

    public void aumentarContador(){
        contador++;
    }
}
