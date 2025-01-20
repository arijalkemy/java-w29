package Ejercicio3;

abstract class Animal {

        private String nombre;

        public Animal(String nombre) {
            this.nombre = nombre;
        }

        public String getNombre() {
            return nombre;
        }

        // Método abstracto para emitir sonido
        public abstract void emitirSonido();
    }


