package com.thiago.local.transporte;

import java.util.Comparator;
import java.util.List;

public class Garage {
    private int id;
    private List<Vehiculo> vehiculos;

    public Garage(int id, List<Vehiculo> vehiculos) {
        this.id = id;
        this.vehiculos = vehiculos;
    }

    public void listarPorPrecioAscendente() {
        ordenarPorPrecioAscendente(vehiculos).forEach(System.out::println);
    }

    public void listarPorMarcaYPrecioAscendente() {
        ordenarPorMarcaYPrecioAscendente(vehiculos).forEach(System.out::println);
    }

    private List<Vehiculo> ordenarPorMarcaYPrecioAscendente(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .sorted((v1, v2) -> {
                    int comparacionMarca = v1.getMarca().compareTo(v2.getMarca());
                    if (comparacionMarca == 0) {
                        double resto = (v1.getCosto() - v2.getCosto());
                        if (resto < 0) {
                            resto = -1;
                        }
                        if (resto > 0) {
                            resto = 1;
                        }
                        return (int) resto;
                    }
                    return comparacionMarca;
                })
                .toList();
    }

    public List<Vehiculo> obtenerVehiculosConPrecioMenorA(double precioMaximo) {
        return vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() < precioMaximo).toList();
    }

    public List<Vehiculo> obtenerVehiculosConPrecioMayorOIgualA(double precioMinimo) {
        return vehiculos.stream().filter(vehiculo -> vehiculo.getCosto() >= precioMinimo).toList();
    }

    public double obtenerPromedioPrecios() {
        if (vehiculos.isEmpty()) {
            return 0;
        }
        return vehiculos.stream().map(Vehiculo::getCosto).reduce(Double::sum).orElse(0.0) / vehiculos.size();
    }

    private List<Vehiculo> ordenarPorPrecioAscendente(List<Vehiculo> vehiculos) {
        return vehiculos.stream()
                .sorted(Comparator.comparingDouble(Vehiculo::getCosto))
                .toList();
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
}
