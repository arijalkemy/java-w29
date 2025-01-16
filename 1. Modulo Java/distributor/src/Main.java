public class Main {
    public static void main(String[] args) {
        Perecedero roastBeef = new Perecedero("Roast Beef", 3000.00, 3);
        Perecedero lecheEntera = new Perecedero("Leche Entera", 1800.00, 10);
        Perecedero tomate = new Perecedero("Tomate", 230.00, 1);
        NoPerecedero arrozBlanco = new NoPerecedero("Arroz Blanco", 1500.00, "granos");
        NoPerecedero aceiteOliva = new NoPerecedero("Aceite de Oliva", 17000.00, "aceites");

        Producto[] productos = {
                roastBeef,
                lecheEntera,
                tomate,
                arrozBlanco,
                aceiteOliva
        };

        printTotalPrice(productos, 5);

    }

    public static void printTotalPrice(Producto[] productos, int sellingAmount) {
        for(Producto producto : productos) {
            System.out.println(
                    producto.toString() +
                            "Vende " +
                            sellingAmount +
                            " unidades por $" +
                            producto.calcular(sellingAmount) +
                            "."
            );
        }
    }
}