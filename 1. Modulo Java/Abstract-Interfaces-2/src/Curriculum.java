import java.util.ArrayList;
import java.util.List;

public class Curriculum implements Imprimible{
    private String name;
    private Integer edad;
    private List<String> habilidades = new ArrayList<>();

    public Curriculum(String name, Integer edad, List<String> habilidades) {
        this.name = name;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getEdad() {
        return edad;
    }

    public void setEdad(Integer edad) {
        this.edad = edad;
    }

    public List<String> getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List<String> habilidades) {
        this.habilidades = habilidades;
    }

    @Override
    public void imprimir() {
        System.out.println("Nombre de la persona: " + this.name);
        System.out.println("Edad: " + this.edad);
        for(String habilidad : this.habilidades){
            System.out.println("Habilidad: " + habilidad.toString());
        }
    }
}
