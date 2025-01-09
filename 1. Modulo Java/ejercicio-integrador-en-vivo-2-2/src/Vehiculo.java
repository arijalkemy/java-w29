public class Vehiculo {
    protected double velocidad;
    protected double aceleracion;
    protected double anguloDeGiro;
    protected String patente;
    protected double peso;
    protected int cantRuedas;

    public Vehiculo(double velocidad, double anguloDeGiro, double aceleracion, String patente, double peso, int cantRuedas) {
        this.velocidad = velocidad;
        this.anguloDeGiro = anguloDeGiro;
        this.aceleracion = aceleracion;
        this.patente = patente;
        this.peso = peso;
        this.cantRuedas = cantRuedas;
    }

    public double getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(double velocidad) {
        this.velocidad = velocidad;
    }

    public double getAceleracion() {
        return aceleracion;
    }

    public void setAceleracion(double aceleracion) {
        this.aceleracion = aceleracion;
    }

    public double getAnguloDeGiro() {
        return anguloDeGiro;
    }

    public void setAnguloDeGiro(double anguloDeGiro) {
        this.anguloDeGiro = anguloDeGiro;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getCantRuedas() {
        return cantRuedas;
    }

    public void setCantRuedas(int cantRuedas) {
        this.cantRuedas = cantRuedas;
    }
}
