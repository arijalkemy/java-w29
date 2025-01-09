package integrador_p2_e2;

import java.util.*;
import integrador_p2_e2.Socorristas.*;

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
    if(vehiculos.size() <= this.cantidadDeVehiculos) vehiculos.add(new Autos(velocidad, aceleracion, anguloDeGiro, patente));
  }

  public void darDeAltaMoto(Double velocidad, Double aceleracion, Double anguloDeGiro, String patente) {
    if(vehiculos.size() <= this.cantidadDeVehiculos) vehiculos.add(new Motos(velocidad, aceleracion, anguloDeGiro, patente));
  }

  public void eliminarVehiculo(Vehiculo vehiculo) {
    vehiculos.remove(vehiculo);
  }

  public void eliminarVehiculoConPatente(String patente) {
    vehiculos.removeIf(vehiculo -> vehiculo.getPatente().equals(patente));
  }

  public Vehiculo ganador(){
    return vehiculos.stream().max(Comparator.comparing(Vehiculo::calculateScore)).get();
  }

  public void socorrerAuto(String patente){
    Vehiculo auto = vehiculos.stream()
      .filter(vehiculo -> vehiculo instanceof Autos)
      .filter(vehiculo -> vehiculo.getPatente().equals(patente))
      .findFirst().get();
    socorristaAuto.socorrer((Autos) auto);
  }

  public void socorrerMoto(String patente){
    Vehiculo moto = vehiculos.stream()
      .filter(vehiculo -> vehiculo instanceof Motos)
      .filter(vehiculo -> vehiculo.getPatente().equals(patente))
      .findFirst().get();
    socorristaMoto.socorrer((Motos) moto);
  }
}
