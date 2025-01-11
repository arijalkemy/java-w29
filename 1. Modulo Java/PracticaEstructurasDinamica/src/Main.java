import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        //categorias
        Map<String, String> categorias = new HashMap<>();
        categorias.put("chico", "2 km por selva y arroyos.");
        categorias.put("medio", "5 km por selva, arroyos y barro.");
        categorias.put("avanzado", "10 km por selva, arroyos, barro y escalada en piedra.");

        String[][] participantes = {{"Juan","25"}, {"Pedro", "15"}, {"Luis", "35"}};
        Map<String, Object> inscripcion = new HashMap<>();

        for (int i = 0; i < participantes.length; i++ ) {
            for (int j = 0; j < participantes[i].length; j++) {
                int edadd = Integer.parseInt(participantes[j]);
                if (edadd < 18 && categorias.containsKey("medio")){
                    System.out.println("Participante: " + participantes[i] + "inscrito en categoria Medio");
                }
            }
            //System.out.println("Participante: " + participantes[i]);
        }
    }


}