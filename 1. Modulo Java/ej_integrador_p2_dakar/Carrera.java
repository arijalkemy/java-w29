import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private final int cantidadDeVehiculosPermitidos;
    private final List<Vehiculo> vehiculos;
    private final Socorrista<Auto> socorristaAuto;
    private final Socorrista<Moto> socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Auto auto = new Auto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(auto);
        } else {
            System.out.println("No hay cupo para más vehículos.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (vehiculos.size() < cantidadDeVehiculosPermitidos) {
            Moto moto = new Moto(velocidad, aceleracion, anguloDeGiro, patente);
            vehiculos.add(moto);
        } else {
            System.out.println("No hay cupo para más vehículos.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(unaPatente));
    }

    public void socorrerAuto(String patente) {
        socorrer(patente);
    }

    public void socorrerMoto(String patente) {
        socorrer(patente);
    }

    private void socorrer(String patente) {
        vehiculos.stream().filter(vehiculo -> vehiculo.getPatente().equals(patente)).forEach(vehiculo -> {
            if (vehiculo instanceof Auto) {
                socorristaAuto.socorrer((Auto) vehiculo);
            } else {
                socorristaMoto.socorrer((Moto) vehiculo);
            }
        });
    }

    public Vehiculo determinarGanador() {
        return vehiculos.stream()
                .max(Comparator
                        .comparingDouble(v -> v.getVelocidad() * 0.5 * v.getAceleracion() / (v.getAnguloDeGiro() * (v.getPeso() - v.getRuedas() * 100))))
                .orElse(null);
    }

    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getPatente());
        }

    }

}