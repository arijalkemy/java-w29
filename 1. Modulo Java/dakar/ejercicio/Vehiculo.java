package ejercicio;

public class Vehiculo {
    public Double Velocidad;
    public Double Aceleracion;
    public Double AnguloDeGiro;
    public String Patente;
    public Double Peso;
    public Integer Ruedas;

    public Vehiculo(Double aceleracion, Double anguloDeGiro, String patente, Double peso, Integer ruedas, Double velocidad) {
        Aceleracion = aceleracion;
        AnguloDeGiro = anguloDeGiro;
        Patente = patente;
        Peso = peso;
        Ruedas = ruedas;
        Velocidad = velocidad;
    }

    public Vehiculo(Double aceleracion, Double anguloDeGiro, String patente, Double velocidad) {
        Aceleracion = aceleracion;
        AnguloDeGiro = anguloDeGiro;
        Patente = patente;
        Velocidad = velocidad;
    }

    public Double getAceleracion() {
        return Aceleracion;
    }

    public void setAceleracion(Double aceleracion) {
        Aceleracion = aceleracion;
    }

    public Double getAnguloDeGiro() {
        return AnguloDeGiro;
    }

    public void setAnguloDeGiro(Double anguloDeGiro) {
        AnguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return Patente;
    }

    public void setPatente(String patente) {
        Patente = patente;
    }

    public Double getPeso() {
        return Peso;
    }

    public void setPeso(Double peso) {
        Peso = peso;
    }

    public Integer getRuedas() {
        return Ruedas;
    }

    public void setRuedas(Integer ruedas) {
        Ruedas = ruedas;
    }

    public Double getVelocidad() {
        return Velocidad;
    }

    public void setVelocidad(Double velocidad) {
        Velocidad = velocidad;
    }

    public Double puntuacion(){
        return (Velocidad * Aceleracion/2)/(AnguloDeGiro * (Peso - Ruedas* 100));
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "Aceleracion=" + Aceleracion +
                ", Velocidad=" + Velocidad +
                ", AnguloDeGiro=" + AnguloDeGiro +
                ", Patente='" + Patente + '\'' +
                ", Peso=" + Peso +
                ", Ruedas=" + Ruedas +
                '}';
    }
}
