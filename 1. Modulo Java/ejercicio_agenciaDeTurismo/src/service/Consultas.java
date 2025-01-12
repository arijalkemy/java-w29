package service;

import model.Localizador;
import repository.Repositorio;

import java.util.Map;

public class Consultas {

    private Repositorio repositorio;


    public Consultas(Repositorio repositorio) {
        this.repositorio = repositorio;

    }

    public Double calcularTotalVentas(){
        return repositorio.obtenerTodosLosLocalizadores().stream()
                .mapToDouble(Localizador::getPrecioTotalLocalizador)
                .sum();
    }

    public Double calcularPromedioVentas(){
        Double promedio_ventas = 0.0;
        Double total_ventas = calcularTotalVentas();
        promedio_ventas = total_ventas / repositorio.obtenerTotalLocalizadores();

        return promedio_ventas;
    }

    public Integer obtenerCantidadLocalizadoresVendidos(){
        return repositorio.obtenerTotalLocalizadores();
    }

    public Integer obtenerCantidadReservas(){
        return repositorio.obtenerTotalReservas();
    }

    public Map<String, Integer> obtenerDiccionarioCantidadDeReservas(){
        return repositorio.obtenerResumenReservas();
    }
}
