package ejercicio;

import java.util.*;


public class Main {
    static Map<String, Map<String, Object>> categoria = new HashMap<>();

    public static void main(String[] args) {

        // Crear los circuitos, uso Object para admitir cualquier tipo de dato en el valor
        Map<String, Object> circuitoChico = new HashMap<>();
        Map<String, Object> circuitoMedio = new HashMap<>();
        Map<String, Object> circuitoAvanzado = new HashMap<>();

        // Agrego el id, nombre y descrip pensandolo como un "objeto"
        circuitoChico.put("id", 1);
        circuitoChico.put("nombre", "Circuito chico");
        circuitoChico.put("descripcion", "2 km por selva y arroyos.");
        circuitoChico.put("inscriptos", new ArrayList<HashMap<String, Object>>());

        circuitoMedio.put("id", 2);
        circuitoMedio.put("nombre", "Circuito medio");
        circuitoMedio.put("descripcion", "5 km por selva, arroyos y barro.");
        circuitoMedio.put("inscriptos", new ArrayList<HashMap<String, Object>>());

        circuitoAvanzado.put("id", 3);
        circuitoAvanzado.put("nombre", "Circuito avanzado");
        circuitoAvanzado.put("descripcion", "0 km por selva, arroyos, barro y escalada en piedra.");
        circuitoAvanzado.put("inscriptos", new ArrayList<HashMap<String, Object>>());

        // Agrego los circuitos a las categorías
        categoria.put("circuito chico", circuitoChico);
        categoria.put("circuito medio", circuitoMedio);
        categoria.put("circuito avanzado", circuitoAvanzado);

        //Inscribo un participante en alguna categoria
        inscribirParticipante("4163232", "Lucas", 25, "11587432432", "321321321", "A+", "circuito chico", false);

        //Inscribo mas participantes en categorias de forma aleatoria
        inscribirParticipante("4163232", "Santiago", 25, "1158741532432", "3213321321", "A+", "circuito chico", true);
        inscribirParticipante("36323232", "Juan", 25, "11587435412432", "321321321", "A+", "circuito chico", true);
        inscribirParticipante("2163232", "Pedro", 25, "1158776432432", "32131221321", "A+", "circuito chico", true);

        //Mostrar inscriptos de la categoria circuito chico
        List<HashMap<String, Object>> inscrip = (List<HashMap<String, Object>>) circuitoChico.get("inscriptos");

        for (HashMap<String, Object> map : inscrip) {
            System.out.println("Numero de participante: " + map.get("numParticipante") + ", dni: " + map.get("dni") + ", nombre: " + map.get("nombre") + ", edad: " + map.get("edad") + ", celular: " + map.get("celular") + ", numero emergencia: " + map.get("numEmergencia") + ", grupoSanguineo: " + map.get("grupoSanguineo") + ", monto: " + map.get("monto") + ", categoria: " + map.get("categoria"));
        }

        //Monto total por cada categoria
        System.out.println("Monto total recaudado circuito chico:" + calcularMontoCategoria("circuito chico"));
        System.out.println("Monto total recaudado circuito medio:" + calcularMontoCategoria("circuito medio"));
        System.out.println("Monto total recaudado circuito avanzado:" + calcularMontoCategoria("circuito avanzado"));
    }

    public static void inscribirParticipante(String dni, String nombre, int edad, String celular, String numEmergencia, String grupoSanguineo, String cate, boolean aleatorio) {
        //Calculo el monto a abonar
        int monto = obtenerMonto(cate, edad);
        if (monto == -1) {
            new RuntimeException("No se puede inscribir participante porque su edad es menor a 18");
        }

        //Creo numero de participante aleatorio del 1 al 20
        Random random = new Random();
        int numParticipante = random.nextInt(21);

        //Creo el HashMap del participante
        HashMap<String, Object> participante = new HashMap<>();
        participante.put("numParticipante", numParticipante);
        participante.put("dni", dni);
        participante.put("nombre", nombre);
        participante.put("edad", edad);
        participante.put("celular", celular);
        participante.put("numEmergencia", numEmergencia);
        participante.put("grupoSanguineo", grupoSanguineo);
        participante.put("monto", monto);

        if (!aleatorio) {
            participante.put("categoria", cate);
        } else {
            String[] nombresCategorias = {"circuito chico", "circuito medio", "circuito avanzado"};
            String nuevaCategoria = nombresCategorias[random.nextInt(3)];
            participante.put("categoria", nuevaCategoria);
            cate = nuevaCategoria; //Reemplazo cate por la nueva categoria
        }

        //Agrego al participante a la categoria pasada por parametro
        List<HashMap<String, Object>> inscriptos = (List<HashMap<String, Object>>) categoria.get(cate).get("inscriptos");
        inscriptos.add(participante);
    }

    public static int obtenerMonto(String categoria, int edad) {
        if (categoria.equals("circuito chico")) {
            return (edad < 18) ? 1300 : 1500;
        } else if (categoria.equals("circuito medio")) {
            return (edad < 18) ? 2000 : 2300;
        } else if (categoria.equals("circuito avanzado")) {
            if (edad < 18) {
                return -1; // numeoro para no permitir insrcipcion
            }
            return 2800;
        }
        return 0;
    }

    public static int calcularMontoCategoria(String categ) {
        List<HashMap<String, Object>> inscrip = (List<HashMap<String, Object>>) categoria.get(categ).get("inscriptos");
        int monto = 0;
        for (HashMap<String, Object> map : inscrip) {
            monto += (Integer) map.get("monto"); //Como es un object hay que castearlo a integer
        }

        return monto;
    }
}
