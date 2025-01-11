import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    private Double distancia;
    private Double premioEnDolares;
    private String nombre;
    private Integer cantidadDeVehiculos;
    private List<Vehiculo> vehiculos;
    private SocorristaAuto socorristaAuto;
    private SocorristaMoto socorristaMoto;

    public Carrera(Double distancia, Double premioEnDolares, String nombre, Integer cantidadDeVehiculos) {
        this.distancia = distancia;
        this.premioEnDolares = premioEnDolares;
        this.nombre = nombre;
        this.cantidadDeVehiculos = cantidadDeVehiculos;
        vehiculos = new ArrayList<Vehiculo>();
        socorristaAuto = new SocorristaAuto();
        socorristaMoto = new SocorristaMoto();
    }

    public void darDeAltaAuto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < this.cantidadDeVehiculos) {
            Autos auto = new Autos(velocidad, aceleracion, anguloDeGiro, patente);
            System.out.println("Agregando Auto con patente: " + patente);
            System.out.println(auto);
            vehiculos.add(auto);
        }
    }

    public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
        if (vehiculos.size() < this.cantidadDeVehiculos) {
            Motos moto = new Motos(velocidad, aceleracion, anguloDeGiro, patente);
            System.out.println("Agregando Moto con patente: " + patente);
            System.out.println(moto);
            vehiculos.add(moto);
        }

    }

    public void eliminarVehiculo(Vehiculo vehiculo) {
        vehiculos.remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente) {
        vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public Vehiculo ganador() {
        return vehiculos.stream()
                .max(Comparator.comparing(Vehiculo::calculateScore))
                .orElseThrow(() -> new IllegalStateException("No se encontró ningún vehículo en la carrera"));
    }


    public void socorrerAuto(String patente){
        Optional<Vehiculo> autoOptional = vehiculos.stream()
                .filter(vehiculo -> vehiculo instanceof Autos)
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();

        // Verificar si se encontró el vehículo
        autoOptional.ifPresentOrElse(
                auto -> socorristaAuto.socorrer((Autos) auto), // Si se encuentra, socorrer el auto
                () -> System.out.println("---- Error: No se encontró ningún auto con la patente " + patente)
        );
    }

    public void socorrerMoto(String patente){
        Optional<Vehiculo> motoOptional = vehiculos.stream()
                .filter(vehiculo -> vehiculo instanceof Motos)
                .filter(vehiculo -> vehiculo.getPatente().equals(patente))
                .findFirst();

        // Verificar si se encontró el vehículo
        motoOptional.ifPresentOrElse(
                moto -> socorristaMoto.socorrer((Motos) moto), // Si se encuentra, socorrer la moto
                () -> System.out.println("---- Error: No se encontró ninguna moto con la patente " + patente) // Mensaje de error si no se encuentra
        );
    }
}