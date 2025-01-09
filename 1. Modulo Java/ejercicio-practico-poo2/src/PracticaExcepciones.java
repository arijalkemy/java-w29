public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;

    public static void main(String[] args) {

        //Ejercicio 1

        PracticaExcepciones prac = new PracticaExcepciones();

        try {
            double cociente = prac.b/prac.a;
        }catch(Exception e) {
            System.out.println("Se ha producido un error: " + e.getMessage());
        }finally{
            System.out.println("Programa finalizado");
        }

        //Ejercicio 2

       PracticaExcepciones prac2 = new PracticaExcepciones();

        try{
            double cociente = prac2.b/prac2.a;
        }catch(Exception e){
            throw new IllegalArgumentException("No se puede dividir por cero");
        }finally {
            System.out.println("Programa finalizado");
        }

    }

}
