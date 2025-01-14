package ejercicio;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Carrera {
    public Double Distancia;
    public Integer PremioEnDolares;
    public String Nombre;
    public Integer CantidadDeVehiculosPermitidos;
    public List<Vehiculo> Vehiculos;

    public Integer getCantidadDeVehiculosPermitidos() {
        return CantidadDeVehiculosPermitidos;
    }

    public void setCantidadDeVehiculosPermitidos(Integer cantidadDeVehiculosPermitidos) {
        CantidadDeVehiculosPermitidos = cantidadDeVehiculosPermitidos;
    }

    public List<Vehiculo> getVehiculos() {
        return Vehiculos;
    }

    public void setVehiculos(List<Vehiculo> vehiculos) {
        Vehiculos = vehiculos;
    }

    public void darDeAltaAuto(Auto auto){
        if(Vehiculos.toArray().length + 1 <= getCantidadDeVehiculosPermitidos()) {
            Vehiculos.add(auto);
        }
        else{
            System.out.println("La cantidad de vehiculos supera la capacidad, espera a la siguiente carrera");
        }
    }

    public void darDeAltaMoto(Moto moto){
        if(Vehiculos.toArray().length + 1 <= getCantidadDeVehiculosPermitidos()) {
            Vehiculos.add(moto);
        }
        else{
            System.out.println("La cantidad de vehiculos supera la capacidad, espera a la siguiente carrera");
        }
    }

    public void eliminarVehiculo(Vehiculo vehiculo){
        getVehiculos().remove(vehiculo);
    }

    public void eliminarVehiculoConPatente(String patente){
        getVehiculos().removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
    }

    public String definirGanador(){
        Vehiculo ganador = null;
        Optional<Vehiculo> vehiculo = getVehiculos().stream().max(Comparator.comparingDouble(Vehiculo::puntuacion));
        if (vehiculo.isPresent()) {
            ganador = vehiculo.get();
        }
        return ("El ganador es" + ganador.toString());
    }
}
