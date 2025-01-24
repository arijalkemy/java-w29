package org.melibootcamp.links.dto;

public class LinkDTo {
    private Long id;
    private String url;
    private Integer contador=0;

    public LinkDTo(Long id, String url, Integer contador) {
        this.id = id;
        this.url = url;
        this.contador = contador;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
}
