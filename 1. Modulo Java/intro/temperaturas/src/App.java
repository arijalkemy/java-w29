public class App {
    public static void main(String[] args) throws Exception {
        String [] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        double [][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27},
        {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}
        , {-1, 31}, {-10, 35}};
        String ciudadMin = ciudades[0];
        String ciudadMax = ciudades[0];
        double maxTemp = temperaturas[0][1];
        double minTemp = temperaturas[0][0];
        for (int i_ciudad=1;i_ciudad<ciudades.length;i_ciudad++){
            if (temperaturas[i_ciudad][0]<minTemp){
                minTemp = temperaturas[i_ciudad][0];
                ciudadMin = ciudades[i_ciudad];
            }
            if (temperaturas[i_ciudad][1]>maxTemp){
                maxTemp = temperaturas[i_ciudad][1];
                ciudadMax = ciudades[i_ciudad];
            }
        }
        System.out.println("La menor temperatura la tuvo " + ciudadMin + ", con " + minTemp + " ºC.");
        System.out.println("La mayor temperatura la tuvo " + ciudadMax + ", con " + maxTemp + " ºC.");
    }
}
