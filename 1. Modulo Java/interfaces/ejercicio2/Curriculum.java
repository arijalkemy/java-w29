package ejercicio2;

public class Curriculum implements Documentos{
    public String nombre;
    public String carrera;
    public String[] atributos;

    @Override
    public String imprimir() {
        return nombre + " " + carrera + " " + atributos.toString();
    }

    public Curriculum(String[] atributos, String carrera, String nombre) {
        this.atributos = atributos;
        this.carrera = carrera;
        this.nombre = nombre;
    }
}
