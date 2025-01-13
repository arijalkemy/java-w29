import java.util.Comparator;
import java.util.List;

public class Carrera<T extends Vehiculo> {
    private double distancia;
    private double premioEnDolares;
    private String nombre;
    private int cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(double distancia, double premioEnDolares, String nombre, int cantidadDeVehiculosPermitidos, List<Vehiculo> vehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
        this.vehiculos = vehiculos;
    }

    private boolean hayLugar() {
        return vehiculos.size() < cantidadDeVehiculosPermitidos;
    }

    public void darDeAltaAuto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (hayLugar()) {
            vehiculos.add(new Auto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else {
            System.out.println("No se puede dar de alta el auto porque no hay más lugar en la carrera.");
        }
    }

    public void darDeAltaMoto(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        if (hayLugar()) {
            vehiculos.add(new Moto(velocidad, aceleracion, anguloDeGiro, patente));
        }
        else {
            System.out.println("No se puede dar de alta el auto porque no hay más lugar en la carrera.");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String unaPatente) {
        vehiculos.remove(getVehiculoByPatente(unaPatente));
    }

    public Vehiculo getGanador() {
        return vehiculos.stream().max(Comparator.comparing(Vehiculo::getValorImportante)).orElse(null);
    }

    private Vehiculo getVehiculoByPatente(String patente) {
        return vehiculos.stream().filter(v -> v.getPatente().equals(patente)).findFirst().orElse(null);
    }

    public void socorrerVehiculo(String patente) {
        Vehiculo vehiculo = getVehiculoByPatente(patente);
        if (vehiculo instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo);
        } else if (vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo);
        }
    }

    public double getDistancia() {
        return distancia;
    }

    public void setDistancia(double distancia) {
        this.distancia = distancia;
    }

    public double getPremioEnDolares() {
        return premioEnDolares;
    }

    public void setPremioEnDolares(double premioEnDolares) {
        this.premioEnDolares = premioEnDolares;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidadDeVehiculosPermitidos() {
        return cantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(int cantidadDeVehiculosPermitidos) {
        this.cantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }

    public SocorristaMoto getSocorristaMoto() {
        return socorristaMoto;
    }

    public void setSocorristaMoto(SocorristaMoto socorristaMoto) {
        this.socorristaMoto = socorristaMoto;
    }

    public SocorristaAuto getSocorristaAuto() {
        return socorristaAuto;
    }

    public void setSocorristaAuto(SocorristaAuto socorristaAuto) {
        this.socorristaAuto = socorristaAuto;
    }
}
