public class Main {
  static String[] cities = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "São Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
  static int identityMatrix[][] = {
    {-2, -3, -8, 4, 6, 5, 0, -7, -1, -10},
    {33, 32, 27, 37, 42, 43, 39, 26, 31, 35}
  };

  public static void main(String[] args) {
    int min = Integer.MAX_VALUE;
    int minIndex = 0;
    for(int i = 0; i < identityMatrix[0].length; i++){
      if (identityMatrix[0][i] < min) {
        min = identityMatrix[0][i];
        minIndex = i;
      }
    }
    int max = Integer.MIN_VALUE;
    int maxIndex = 0;
    for(int i = 0; i < identityMatrix[1].length; i++){
      if (identityMatrix[1][i] > max) {
        max = identityMatrix[1][i];
        maxIndex = i;
      }
    }
    System.out.println("La ciudad con la temperatura más baja es " + cities[minIndex] + " con " + min + " grados.");
    System.out.println("La ciudad con la temperatura más alta es " + cities[maxIndex] + " con " + max + " grados.");
  }
}