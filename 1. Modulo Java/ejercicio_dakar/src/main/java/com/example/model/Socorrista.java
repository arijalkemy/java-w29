package com.example.model;

public interface Socorrista<T extends Vehiculo>{
    void socorrer(T vehiculo);
}