package Models;

public class PracticaExcepciones {
    int a = 0;
    int b = 300;

    public void calcularCociente(){
        try{
            if(a == 0){
                throw new IllegalArgumentException("No se puede dividir por 0");
            }
            double cociente = b / a;
            System.out.println(cociente);
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }finally {
            System.out.println("Programa finalizado");
        }
    }
}
