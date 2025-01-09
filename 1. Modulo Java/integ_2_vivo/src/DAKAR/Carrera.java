package DAKAR;

import DAKAR.factory.AutoFactory;
import DAKAR.factory.MotoFactory;
import DAKAR.model.Auto;
import DAKAR.model.Moto;
import DAKAR.model.Vehiculo;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
@AllArgsConstructor
public class Carrera {

    private final double distancia;
    private final double premioEnDolares;
    private final String nombre;
    private final int cantidadDeVehiculosPermitidos;
    private final Socorrista<Auto> socorristaAuto;
    private final Socorrista<Moto> socorristaMoto;
    private final List<Vehiculo> vehiculos = new ArrayList<>();

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo auto = new AutoFactory().crearVehiculo(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
            System.out.println("Auto con patente " + patente + " agregado a la carrera.");
        } else {
            System.out.println("No hay cupo para más autos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Vehiculo moto = new MotoFactory().crearVehiculo(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
            System.out.println("Moto con patente " + patente + " agregada a la carrera.");
        } else {
            System.out.println("No hay cupo para más motos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(v -> v.getPatente().equals(unaPatente));
    }

    public void definirGanador() {
        vehiculos.stream()
                .max(Comparator.comparingDouble(v -> v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100)))).ifPresent(ganador -> System.out.println("El ganador es el vehículo con patente: " + ganador.getPatente()));
    }

    private <T extends Vehiculo> void socorrerVehiculo(String patente, Class<T> tipoVehiculo, Socorrista<T> socorrista) {
        vehiculos.stream()
                .filter(tipoVehiculo::isInstance)
                .filter(v -> v.getPatente().equals(patente))
                .map(tipoVehiculo::cast)
                .findFirst()
                .ifPresent(socorrista::socorrer);
    }

    public void socorrerAuto(String patente) {
        socorrerVehiculo(patente, Auto.class, socorristaAuto);
    }

    public void socorrerMoto(String patente) {
        socorrerVehiculo(patente, Moto.class, socorristaMoto);
    }


}
