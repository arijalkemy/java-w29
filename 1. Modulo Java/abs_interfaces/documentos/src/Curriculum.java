import java.util.List;

public class Curriculum implements Imprimible{
    private String nombrePresona;
    private int edadPersona;
    List<String> habilidades;
    public Curriculum(String nombre, int edad, List<String> habilidades){
        this.nombrePresona = nombre;
        this.edadPersona = edad;
        this.habilidades = habilidades;
    }
    @Override
    public void Imprimir() {
        System.out.printf("Nombre: %s, edad: %s, Habilidades: %s\n", this.nombrePresona, this.edadPersona, this.habilidades.toString());
    }
}
