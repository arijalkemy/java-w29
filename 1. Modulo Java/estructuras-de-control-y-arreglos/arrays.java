public class arrays {
    public static void main(String[] args) {
        Integer[][] temperaturas = {
                {-2, 33},
                {-3, 32},
                {-8, 27},
                {4, 37},
                {6, 42},
                {5, 43},
                {0, 39},
                {-7, 26},
                {-1, 31},
                {-10, 35}
        };

        String[] ciudades = {
                "Londres",
                "Madrid",
                "Nueva York",
                "Buenos Aires",
                "Asunción",
                "San Paulo",
                "Lima",
                "Santiago de Chile",
                "Lisboa",
                "Tokio"
        };

        Integer tempMax = 0;
        Integer tempMin = 0;
        String ciudadMin = "";
        String ciudadMax = "";
        for (int i = 0; i < ciudades.length; i+=1) {
            if(temperaturas[i][0] < tempMin){
                tempMin = temperaturas[i][0];
                ciudadMin = ciudades[i];
            }
            if(temperaturas[i][1] > tempMax){
                tempMax =temperaturas[i][1];
                ciudadMax = ciudades[i];
            }
        }
        System.out.println("La ciudad con menor temperatura fue " + ciudadMax + " con: " + tempMin.toString());
        System.out.println("La ciudad con mayor temperatura fue " + ciudadMin + " con: " + tempMax.toString());
    }


}
