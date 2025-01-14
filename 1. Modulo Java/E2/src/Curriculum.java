public class Curriculum implements Imprimir{
    private String nombrePersona;
    private String [] habilidades;

    public Curriculum(String nombrePersona, String[] habilidades) {
        this.nombrePersona = nombrePersona;
        this.habilidades = habilidades;
    }
    @Override
    public void imprimir() {
        System.out.println("Curriculum: ");
        System.out.println("Nombre: " + nombrePersona);
        System.out.println("Habilidades: ");
        for(String habilidad : habilidades) {
            System.out.println(habilidad + " ");
        }
        System.out.println("\n");
    }
}
