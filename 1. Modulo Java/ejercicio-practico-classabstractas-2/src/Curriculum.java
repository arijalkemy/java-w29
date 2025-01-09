public class Curriculum implements Imprimible {

    private String nombre;
    private String apellido;
    private int edad;
    private String habilidades;

    public Curriculum(String nombre, String apellido, int edad, String habilidades) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.habilidades = habilidades;
    }

    public void imprimirDoc() {
        System.out.println("Nombre: " + nombre + " Apellido: " + apellido + " Edad: " + edad + " Habilidades: " + habilidades);
    }


}
