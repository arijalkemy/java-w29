package DAKAR.factory;

import DAKAR.model.Vehiculo;

public interface VehiculoFactory {
    Vehiculo crearVehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente);
}
