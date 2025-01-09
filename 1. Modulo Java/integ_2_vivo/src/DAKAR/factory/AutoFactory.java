package DAKAR.factory;

import DAKAR.model.Auto;
import DAKAR.model.Vehiculo;

public class AutoFactory implements VehiculoFactory {
    @Override
    public Vehiculo crearVehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        return new Auto(velocidad, aceleracion, anguloDeGiro, patente);
    }
}
