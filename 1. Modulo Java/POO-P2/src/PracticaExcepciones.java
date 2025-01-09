public class PracticaExcepciones {
    public static void main(String[] args) {
        try{
            int a = 0;
            int b = 300;
            int resultado = 0;
            resultado = b / a;
        }catch(IllegalArgumentException e){
            System.out.println("No se puede dividor por 0");
        }finally{
            System.out.println("Programa Finalizado");
        }
    }
}
