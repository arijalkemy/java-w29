package ejercicio;

public class Auto extends Vehiculo {

    public Auto() {
        // Asignar los valores por defecto específicos para Moto
        super(0.0, 0.0, "AAA000", 1000.0, 4, 0.0);
    }

    public Auto(Double aceleracion, Double anguloDeGiro, String patente, Double velocidad) {
        super(aceleracion, anguloDeGiro, patente, velocidad);
    }
}
