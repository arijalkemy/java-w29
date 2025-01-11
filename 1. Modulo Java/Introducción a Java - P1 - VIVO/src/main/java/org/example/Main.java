package org.example;

public class Main {
    public static void main(String[] args) {
        Map<String, List<Integer>> temperaturaPaises = new HashMap<>(
                Map.ofEntries(
                        Map.entry("Londres", List.of(-2,33)),
                        Map.entry("Madrid", List.of(-3,32)),
                        Map.entry("Nueva York", List.of(-8,27)),
                        Map.entry("Buenos Aires", List.of(4,37)),
                        Map.entry("Asuncion", List.of(6,42)),
                        Map.entry("Sao Pablo", List.of(5,43)),
                        Map.entry("Lima", List.of(0,39)),
                        Map.entry("Santiado de Chile", List.of(-7,26)),
                        Map.entry("Lisboa", List.of(-1,31)),
                        Map.entry("Tokio", List.of(-10,35))
                )
        );

        int temperaturaMasBaja = Integer.MAX_VALUE;
        int temperaturaMasAlta = Integer.MIN_VALUE;
        String ciudadMasAlta = "";
        String ciudadMasBaja = "";

        for (Map.Entry<String, List<Integer>> entry : temperaturaPaises.entrySet()) {
            String ciudad = entry.getKey();
            int temperaturaMinima = entry.getValue().get(0);
            int temperaturaMaxima = entry.getValue().get(1);

            if (temperaturaMinima < temperaturaMasBaja) {
                temperaturaMasBaja = temperaturaMinima;
                ciudadMasBaja = ciudad;
            }

            if (temperaturaMaxima > temperaturaMasAlta) {
                temperaturaMasAlta = temperaturaMaxima;
                ciudadMasAlta = ciudad;
            }
        }

        System.out.println("La menor temperatura fue en " + ciudadMasBaja + ", con " + temperaturaMasBaja + " grados");
        System.out.println("La mayor temperatura fue en " + ciudadMasAlta + ", con " + temperaturaMasAlta + " grados");
    }
}
