package models;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Data
public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadVehiculosPermitidos = cantidadVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupo()) return;
        if (existeVehiculo(patente)) return;
        vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (!hayCupo()) return;
        if (existeVehiculo(patente)) return;
        vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public Vehiculo determinarGanador() {
        return this.vehiculos.stream()
                .max(Comparator.comparingDouble(Vehiculo::calcularRendimiento))
                .orElse(null);
    }

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Auto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> this.socorristaAuto.socorrer((Auto) v));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Moto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> this.socorristaMoto.socorrer((Moto) v));
    }

    private boolean hayCupo() {
        return this.vehiculos.size() < this.cantidadVehiculosPermitidos;
    }

    private boolean existeVehiculo(String patente) {
        return vehiculos.stream().anyMatch(vehiculo -> vehiculo.getPatente().equals(patente));
    }
}
