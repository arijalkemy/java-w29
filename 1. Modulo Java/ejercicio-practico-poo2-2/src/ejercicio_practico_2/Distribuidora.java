package ejercicio_practico_2;

public class Distribuidora {


    public static void main(String[] args) {
        Producto[] productos = new Producto[10];
        productos[0] = new Perecedero("Papa",22.9,2);
        productos[1] = new Perecedero("Cebolla",32.5,2);
        productos[2] = new Perecedero("Zanahoria",52.3,2);
        productos[3] = new Perecedero("Papa",12.5,3);
        productos[4] = new Perecedero("Morron",72.7,1);

        productos[5] = new NoPerecedero("Poroto",12.5,"Legumbre");
        productos[6] = new NoPerecedero("Aceite de girasol",42.5,"Aceite");
        productos[7] = new NoPerecedero("Aceite de oliva",33.2,"Aceite");
        productos[8] = new NoPerecedero("Lenteja",52.8,"Legumbre");
        productos[9] = new NoPerecedero("Arbeja",92.5,"Legumbre");

        double precioTotalPerecederos = 0;
        double precioTotalNoPerecederos = 0;

        for(Producto p : productos){
            if(p.getClass() == Perecedero.class){
                precioTotalPerecederos += p.getPrecio();
            }else{
                precioTotalNoPerecederos += p.getPrecio();
            }
        }

        System.out.println("Precio total perecederos: " + precioTotalPerecederos);
        System.out.println("Precio total no perecederos: " + precioTotalNoPerecederos);
    }
}
