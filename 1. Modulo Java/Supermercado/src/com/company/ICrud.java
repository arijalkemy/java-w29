package com.company;

public interface ICrud <T>{
    public T altaProducto(T producto);
    public T bajaProducto(T producto);
    public T modificacionProducto(T producto);
}
