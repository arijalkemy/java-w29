import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) { // Cambiado el constructor
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public List<Vehiculo> getVehiculosList() {
        return new ArrayList<>(vehiculos);
    }

    public int getVehiculosCount() {
        return vehiculos.size();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        } else {
            System.out.println("No hay cupo para más vehículos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (this.vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        } else {
            System.out.println("No hay cupo para más vehículos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        if (vehiculos.contains(vehiculo)) {
            vehiculos.remove(vehiculo);
            System.out.println("Vehículo con patente " + vehiculo.getPatente() + " eliminado exitosamente.");
        } else {
            System.out.println("El vehículo con patente " + vehiculo.getPatente() + " no se encuentra en la lista.");
        }
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        boolean removed = vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));

        if (removed) {
            System.out.println("Vehículo con patente " + unaPatente + " eliminado exitosamente.");
        } else {
            System.out.println("No se encontró ningún vehículo con la patente " + unaPatente + ".");
        }
    }

    public Vehiculo getGanador() {
        return vehiculos.stream()
                .max((v1, v2) -> Double.compare(v1.calcularRendimiento(), v2.calcularRendimiento()))
                .orElse(null);
    }

    public void socorrerAuto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Auto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> socorristaAuto.socorrer((Auto) v));
    }

    public void socorrerMoto(String patente) {
        vehiculos.stream()
                .filter(v -> v instanceof Moto && v.getPatente().equals(patente))
                .findFirst()
                .ifPresent(v -> socorristaMoto.socorrer((Moto) v));
    }
}