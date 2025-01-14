public class Main {
    public static void main(String[] args) {
        /*int a=0;
        int b=300;

        try{
            if (a==0){
                throw new IllegalArgumentException("No se puede dividir por cero", exception);
            }
            double cociente= b/a;
        } catch (ArithmeticException exception) {
            System.out.println("Se ha producido un error" + exception.getMessage());

        } finally {
            System.out.println("Programa finalizado");
        }*/

        Producto productos[] = new Producto[6];

        productos[0] = new Producto("Leche", 2.5);
        productos[1] = new Producto("Pan", 1.0);
        //tipo Perecedero
        productos[2] = new Perecedero("Yogurt", 1.2, 2);
        productos[3] = new Perecedero("Queso", 3.0, 1);
        //tipo NoPerecedero
        productos[4] = new NoPerecedero("Conservas de Atún", 1.5, "Conservas");
        productos[5] = new NoPerecedero("Cereal", 2.0, "Desayuno");

        double total = 0.0;

        // Iterar sobre el array de productos y calcular el precio total por cada tipo de producto
        for (Producto producto : productos) {
            double precioTotal = producto.calcular(5);
            total += precioTotal;
            System.out.println(producto.toString());
            System.out.println("Precio total por 5 unidades: " + precioTotal);
            System.out.println("----------------------------------");
        }

        System.out.println("Precio total por vender 5 unidades de cada producto: " + total);

    }
}