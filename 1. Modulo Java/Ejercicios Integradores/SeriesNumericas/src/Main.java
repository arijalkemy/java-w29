public class Main {
    public static void main(String[] args) {
        SerieEnteros serie2 = new SerieEnteros(0, 2);  // Inicializando desde 0
        System.out.println("Serie de 2 Enteros:");
        for (int i = 0; i < 4; i++) {
            System.out.println(serie2.siguienteValor());
        }

        // Reinicia a partir de 1
        serie2.reiniciar(1);
        System.out.println("\nSerie de 2 Enteros a partir de 1:");
        for (int i = 0; i < 4; i++) {
            System.out.println(serie2.siguienteValor());
        }

        // Establece el valor inicial en 64
        serie2.establecerValorInicial(64);
        System.out.println("\nSerie de 2s Enteros a partir de 64:");
        for (int i = 0; i < 4; i++) {
            System.out.println(serie2.siguienteValor());
        }

        SerieFlotantes serie3 = new SerieFlotantes(0.0, 3.0);  // Inicializando desde 0.0
        System.out.println("\nSerie de 3 con numeros flotantes:   ");
        for (int i = 0; i < 4; i++) {
            System.out.println(serie3.siguienteValor());
        }
    }
}