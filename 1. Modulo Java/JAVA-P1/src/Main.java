public class TemperaturasGlobales {
    public static void main(String[] args) {

        String ciudades[] = new String[10];
        Integer temperaturas[][] = new Integer[10][2];


        Scanner sc = new Scanner(System.in);
        for (int l = 0; l < 10; l++) {
            System.out.println("Ingrese la ciudad: ");
            ciudades[l] = sc.nextLine();
            Scanner sc2 = new Scanner(System.in);

            for (int j = 0; j < 2; j++) {
                if (j == 0) {
                    System.out.println("Ingrese la temperatura minima");
                    temperaturas[l][j] = sc2.nextInt();
                } else {
                    System.out.println("Ingrese la temperatura maxima");
                    temperaturas[l][j] = sc2.nextInt();
                }
            }

        }
        int mayor = 0;
        int menor = 0;
        int posMenor = 0;
        int posMayor = 0;
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 2; j++){
                if(temperaturas[i][j] < menor){
                    menor = temperaturas[i][j];
                    posMenor = i;
                }
            }
        }
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 2; j++){
                if(temperaturas[i][j] > mayor){
                    mayor = temperaturas[i][j];
                    posMayor = i;
                }
            }
        }
        String paisMayor = ciudades[posMayor];
        String paisMenor = ciudades[posMenor];
        System.out.println("La menor temperatura es: " + menor + " con país :" + paisMenor);
        System.out.println("La mayor temperatura es: " + mayor + "con país :" + paisMayor);

    }
}
