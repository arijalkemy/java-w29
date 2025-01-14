package ejercicio2;

public interface Documentos {
    public  default String imprimir(){
        return "El documento es imprimido";
    }
}
