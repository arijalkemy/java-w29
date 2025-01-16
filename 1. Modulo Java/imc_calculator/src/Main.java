//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona personaDatosPredeterminados = new Persona();
        Persona personaAlgunosDatos = new Persona("Martin", 25, "12345678");
        Persona personaDatosCompletos = new Persona("Bob", 88, "4123456", 70, 175);

        // Falla...
        // Persona personaNombreEdad = new Persona("Pedro", 18);

        personaDatosPredeterminados.printAllAttributes();
        personaAlgunosDatos.printAllAttributes();
        personaDatosCompletos.printAllAttributes();

        personaDatosPredeterminados.calculateIMC();
        personaAlgunosDatos.calculateIMC();
        personaDatosCompletos.calculateIMC();

        personaDatosPredeterminados.isOfLegalAge();
        personaAlgunosDatos.isOfLegalAge();
        personaDatosCompletos.isOfLegalAge();
    }
}
