package org.example.clases;
//De cada item o producto se guarda el código, nombre, cantidad comprada y costo unitario.
public class Item {
    private Integer id;
    private String codigo;
    private String nombre;
    private Integer catidad;
    private Double costoUnit;

    //Contructores
    public Item() {
    }

    public Item(Integer id,String codigo, String nombre, Integer catidad, Double costoUnit) {
        this.id = id;
        this.codigo = codigo;
        this.nombre = nombre;
        this.catidad = catidad;
        this.costoUnit = costoUnit;
    }

    //getters y setters

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCatidad() {
        return catidad;
    }

    public void setCatidad(Integer catidad) {
        this.catidad = catidad;
    }

    public Double getCostoUnit() {
        return costoUnit;
    }

    public void setCostoUnit(Double costoUnit) {
        this.costoUnit = costoUnit;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    //to sitring

    @Override
    public String toString() {
        return "Item[" +
                "codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", catidad=" + catidad +
                ", costoUnit=" + costoUnit +
                ']';
    }
}
