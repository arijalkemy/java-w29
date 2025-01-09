public abstract class Animal {
    public abstract void emitirSonido();
    public static void comerAnimal(Animal a){

        if(a instanceof Gato){ //forma1: Verifico si es una instancia de la clase Gato
            ((Gato) a).comerCarne();
        }else if(a.getClass().equals(Perro.class)){ //forma2: Obtengo la clase y la comparo con la clase Perro (estoy comparando 2 objetos de tipo class)
            ((Perro) a).comerCarne();
        }else{
            ((Vaca) a).comerHierba();
        }
    }
}
