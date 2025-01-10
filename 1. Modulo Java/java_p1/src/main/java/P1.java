public class P1 {
    public static void main(String[] args) {
        String[] ciudades = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asuncion","Sao Pablo","Lima","Santiago de Chile", "Lisboa","Tokio"};
        int[][] temperaturas = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int[] minMax = findMinMax(temperaturas);
        System.out.println("La ciudad con menor temperatura es: " + ciudades[minMax[0]] + ", y la ciudad con mayor temperatura es: " + ciudades[minMax[1]]);
    }

    private static int[] findMinMax(int[][] matrix) {
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i][0] < min) {
                min = i;
            }
            if (matrix[i][0] > max) {
                max = i;
            }
        }
        return new int[]{min, max};
    }
}
