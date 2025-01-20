package Ex2;

public interface Imprimible{

    public static <T>  void imprimir(T file) {
        System.out.println(file.toString());
    }
}
