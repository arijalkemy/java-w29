public class Main {
    public static void main(String[] args) {

        Subclase1 subclase1 = new Subclase1(2);
        subclase1.establecerValorInicial(0);
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println("reiniciando serie");
        subclase1.reiniciarSerie();
        System.out.println(subclase1.obtenerSiguienteValor());
        subclase1.establecerValorInicial(20);
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println(subclase1.obtenerSiguienteValor());
        System.out.println("----------- SUBCLASE2---------------");
        Subclase2 subclase2 = new Subclase2(3);
        subclase2.establecerValorInicial(0);
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println("reiniciando serie");
        subclase2.reiniciarSerie();
        subclase2.establecerValorInicial(20);
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println(subclase2.obtenerSiguienteValor());
        System.out.println(subclase2.obtenerSiguienteValor());
    }
}