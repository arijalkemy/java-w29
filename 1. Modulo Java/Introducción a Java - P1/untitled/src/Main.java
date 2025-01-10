//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int temperaturas[][] =  {
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
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo"
                ,"Lima", "Santiago de Chile", "Lisboa", "Tokio"};

        int max = 0;
        int min =0;

        for (int i=0; i<= ciudades.length - 1; i++){
            if (temperaturas[i][0]< temperaturas[min][0]) {
                min = i;
            }
            if (temperaturas[i][1]> temperaturas[max][1]) {
                max= i;
            }

        }

        System.out.println("menor temp " + ciudades[min] + ": " + temperaturas[min][0]);
        System.out.println("mayor temp " + ciudades[max] + ": " + temperaturas[max][1]);

    }
}