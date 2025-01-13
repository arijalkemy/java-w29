import java.util.ArrayList;
import java.util.List;

public class Carrera {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private static Socorrista<Auto> socorristaAuto;
    private static Socorrista<Moto> socorristaMoto;

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
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Auto && vehiculo.getPatente().equals(patente)) {
                socorristaAuto.socorrer((Auto) vehiculo);
                return;
            }
        }
        System.out.println("No se encontró un auto con la patente " + patente);
    }

    public void socorrerMoto(String patente) {
        for (Vehiculo vehiculo : vehiculos) {
            if (vehiculo instanceof Moto && vehiculo.getPatente().equals(patente)) {
                socorristaMoto.socorrer((Moto) vehiculo);
                return;
            }
        }
        System.out.println("No se encontró una moto con la patente " + patente);
    }

    public Vehiculo determinarGanador() {
        Vehiculo ganador = null;
        double maxValor = Double.MIN_VALUE;

        for (Vehiculo vehiculo : vehiculos) {
            double valor = vehiculo.getVelocidad() * 0.5 * vehiculo.getAceleracion() /
                    (vehiculo.getAnguloDeGiro() * (vehiculo.getPeso() - vehiculo.getRuedas() * 100));
            if (valor > maxValor) {
                maxValor = valor;
                ganador = vehiculo;
            }
        }

        return ganador;
    }
    public void mostrarVehiculos() {
        for (Vehiculo vehiculo : vehiculos) {
            System.out.println(vehiculo.getPatente());
        }

    }

}