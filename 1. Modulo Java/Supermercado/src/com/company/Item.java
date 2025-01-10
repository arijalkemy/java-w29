package com.company;

public class Item implements ICrud{
    private String codigo;
    private String marca;
    private Double precioUnitario;
    private Integer cantidad;

    public Item(String codigo, String marca, Double precioUnitario, Integer cantidad) {
        this.codigo = codigo;
        this.marca = marca;
        this.precioUnitario = precioUnitario;
        this.cantidad = cantidad;
    }

    public Item() {
    }

    public Double getPrecioTotal(){
        return this.precioUnitario * this.cantidad;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Double getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Double precioUnitario) {
        this.precioUnitario = precioUnitario;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public Object altaProducto(Object producto) {
        System.out.println("Se dio de alta el item: "+producto.toString());
        return producto;
    }

    @Override
    public Object bajaProducto(Object producto) {
        System.out.println("Se dio de baja el item: "+producto.toString());
        return producto;
    }

    @Override
    public Object modificacionProducto(Object producto) {
        System.out.println("Se modifico el item: "+producto.toString());
        return producto;
    }
}
