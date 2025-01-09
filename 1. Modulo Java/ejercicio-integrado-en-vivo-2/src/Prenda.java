public class Prenda {
    private Tipo tipo;
    private String marca;
    private String modelo;

    public Prenda(Tipo tipo,String marca, String modelo) {
        this.tipo = tipo;
        this.marca = marca;
        this.modelo = modelo;
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

    public enum Tipo{
        PANTALON,
        REMERA,
        BUZO,
        ZAPATILLAS
    }

    @Override
    public String toString() {
        return "Prenda: " + tipo +
                " marca: '" + marca + '\'' +
                ", modelo: '" + modelo + '\'' +
                '}';
    }
}
