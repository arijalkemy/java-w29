package spring.ejercicionumerosromanos.service;

public class NumerosRomanosService {
    public String calcularNumeroRomano(int valor) {
        StringBuilder traduccion = new StringBuilder();
        String[] simbolosRomanos = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

        for (int i = 0; i < values.length; i++) {
            while (valor >= values[i]) {
                traduccion.append(simbolosRomanos[i]);
                valor -= values[i];
            }
        }
        return traduccion.toString();
    }
}

