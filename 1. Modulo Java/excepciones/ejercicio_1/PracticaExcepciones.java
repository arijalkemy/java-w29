package ejercicio_1;

public class PracticaExcepciones {
    public Integer a = 0;
    public Integer b = 300;
    public PracticaExcepciones() {}

    public Integer math(){
        try{
            return b/a;
        } catch (Exception exception){
            throw new IllegalArgumentException("No se puede dividir por 0");
        }
    }
}
