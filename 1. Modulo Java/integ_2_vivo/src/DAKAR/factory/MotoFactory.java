package DAKAR.factory;

import DAKAR.model.Moto;
import DAKAR.model.Vehiculo;

public class MotoFactory implements VehiculoFactory {
    @Override
    public Vehiculo crearVehiculo(double velocidad, double aceleracion, double anguloDeGiro, String patente) {
        return new Moto(velocidad, aceleracion, anguloDeGiro, patente);
    }
}
