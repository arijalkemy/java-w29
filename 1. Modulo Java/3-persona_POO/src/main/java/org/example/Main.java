package org.example;

/// 3- Creá una clase nueva llamada Main, donde declares un método main como te enseñamos
/// ///anteriormente. Esto nos permitirá ejecutar nuestra aplicación.
public class Main {
    public static void main(String[] args) {
        /// 4- En la clase Main que acabamos de crear, dentro del método main() te pedimos que crees
        ///un objeto de tipo Persona por cada constructor que hayamos definido en la clase, recuerda
        ///poner un nombre significativo a las variables donde vas a asignar cada objeto. ¿Cómo lo
        ///harías? A continuación vamos a crear otro objeto de tipo persona y vamos a construirlo
        ///pasando solamente un valor para el nombre y otro para la edad en el constructor.
        ///¿Es esto posible? ¿Qué sucede si tratamos de hacer esto?

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Franca",24,"42785599");
        Persona persona3 = new Persona("Silvia",52,"22456788",98.8,1.63);
        ///Persona persona4 = new Persona("Franco",36);
        /// No es posible porque no hay ningun constructor que solo acepte estos dos campos.

        ///6- Desde la clase Main vamos a calcular el IMC de la última persona que creamos
        ///(la que creamos correctamente mediante el constructor que recibe todos los atributos
        ///como parámetro). También vamos a averiguar si es mayor de edad o no; ten en cuenta que
        ///en ambos casos, dependiendo de los resultados retornados por los métodos, debes imprimir
        ///un mensaje acorde para el usuario. Finalmente queremos mostrar todos los datos de esa
        ///persona imprimiendo dicha información por consola. El formato en que vas a mostrar los
        ///datos y los mensajes quedan a tu criterio, pero debe ser legible y descriptivo para quien
        //ve la salida del programa.

        if (persona3.calcularIMC() ==-1){
            System.out.println("El IMC indica que tiene bajo peso");
        }else if(persona3.calcularIMC()==0){
            System.out.println("El IMC indica que Tiene un peso saludable");
        }else{
            System.out.println("El IMC indica que tiene sobrepeso");
        }
        if(persona3.esMayorDeEdad()){
            System.out.println("La persona es mayor de edad");
        }else{
            System.out.println("La persona es menor de edad");
        }

        System.out.println(persona3.toString());
    }
}