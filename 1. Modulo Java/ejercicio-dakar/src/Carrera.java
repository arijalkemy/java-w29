import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Carrera {

    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculosPermitidos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera() {
        this.vehiculos = new ArrayList<>();
        this.socorristaAuto = new SocorristaAuto();
        this.socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double AnguloDeGiro, String patente) {
        if (hayCupo()) {
            Auto auto = new Auto(velocidad, aceleracion, AnguloDeGiro, patente);
            this.vehiculos.add(auto);
        } else {
            throw new RuntimeException("No hay cupo");
        }
    };

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double AnguloDeGiro, String patente) {
        if (hayCupo()) {
            Moto moto = new Moto(velocidad, aceleracion, AnguloDeGiro, patente);
            this.vehiculos.add(moto);
        } else {
            throw new RuntimeException("No hay cupo");
        }
    };

    private Boolean hayCupo() {
        return this.vehiculos.size() < this.cantidadDeVehiculosPermitidos;
    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        this.vehiculos.remove(vehiculo);
    };

    public void eliminarVehiculoConPatente(String patente) {
        this.vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    };

    public Vehiculo determinarGanador() {
        return this.vehiculos.stream().max(Comparator.comparingDouble(Vehiculo::calcularPuntaje)).orElse(null);
    }

    public void socorrer(Vehiculo vehiculo) {
        if (vehiculo instanceof Auto) {
            socorristaAuto.socorrer((Auto) vehiculo);
        } else if (vehiculo instanceof Moto) {
            socorristaMoto.socorrer((Moto) vehiculo);
        }
    }

}
