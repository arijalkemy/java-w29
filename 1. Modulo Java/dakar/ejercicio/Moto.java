package ejercicio;

public class Moto extends Vehiculo {

    public Moto() {
        // Asignar los valores por defecto específicos para Moto
        super(0.0, 0.0, "AAA00A", 300.0, 2, 0.0);
    }

    public Moto(Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas, Double velocidad) {
        super(aceleracion, anguloDeGiro, patente, peso, ruedas, velocidad);
    }

    public Moto(Double aceleracion, Double anguloDeGiro, String patente, Double velocidad) {
        super(aceleracion, anguloDeGiro, patente, velocidad);
    }
}
