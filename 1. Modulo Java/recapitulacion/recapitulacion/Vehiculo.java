package recapitulacion;

public class Vehiculo {
    private String marca;
    private String modelo;
    private String costo;

    public Vehiculo(String costo, String marca, String modelo) {
        this.costo = costo;
        this.marca = marca;
        this.modelo = modelo;
    }

    public String getCosto() {
        return costo;
    }

    public void setCosto(String costo) {
        this.costo = costo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "costo='" + costo + '\'' +
                ", marca='" + marca + '\'' +
                ", modelo='" + modelo + '\'' +
                '}';
    }
}
