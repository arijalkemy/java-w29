# Reglas de Checkstyle

Este documento describe las reglas de **Checkstyle** configuradas para analizar el código fuente Java en este proyecto. Checkstyle es una herramienta de análisis estático que asegura que el código cumpla con las convenciones de estilo definidas.

A continuación se detallan las reglas configuradas en el archivo [checkstyle.xml](../src/main/resources/checkstyle/checkstyle.xml), organizadas por categorías.

## 1. **Reglas Generales**

- **NewlineAtEndOfFile**: Verifica que todos los archivos terminen con una nueva línea. [Más información](https://checkstyle.sourceforge.io/checks/misc/newlineatendoffile.html#NewlineAtEndOfFile)

    **Ejemplo Incorrecto:**
    ```java
    public class Ejemplo {
        public static void main(String[] args) {
            System.out.println("Hola Mundo");
        }
    }
    // No hay nueva línea al final
    ```

- **FileLength**: Verifica que los archivos no superen una longitud máxima definida. [Más información](https://checkstyle.sourceforge.io/checks/sizes/filelength.html#FileLength)

- **RegexpSingleline**: Esta regla verifica que no haya espacios en blanco en una línea vacía o al final de una línea de código. [Más información](https://checkstyle.sourceforge.io/checks/regexp/regexpsingleline.html#RegexpSingleline)

- **LineLength**: Verifica que las líneas de código no excedan un número máximo de caracteres (en este caso, 120). [Más información](https://checkstyle.sourceforge.io/checks/sizes/linelength.html#LineLength)

---

## 2. **Reglas de Nombres**

### **Naming Conventions**
Estas reglas aseguran que el código cumpla con las convenciones de nombres para los diferentes elementos en Java. [Más información](https://checkstyle.sourceforge.io/checks/naming/index.html)

- **ConstantName**: Verifica que los nombres de las constantes estén en mayúsculas y separados por guiones bajos.
  - **Incorrecto**: `private final int maxValue = 10;`
  - **Correcto**: `private final int MAX_VALUE = 10;`
- **LocalFinalVariableName**: Asegura que las variables locales finales tengan nombres en minúsculas.
  - **Incorrecto**: `final int MAX_LIMIT = 100;`
  - **Correcto**: `final int maxLimit = 100;`
- **LocalVariableName**: Asegura que las variables locales sigan las convenciones de nomenclatura.
  - **Incorrecto**: `int MyVariable = 10;`
  - **Correcto**: `int myVariable = 10;`
- **MemberName**: Verifica que los nombres de los miembros de la clase (atributos) sigan las convenciones.
  - **Incorrecto**: `private String first_name;`
  - **Correcto**: `private String firstName;`
- **MethodName**: Asegura que los métodos utilicen la convención de nombres en minúsculas con el estilo `camelCase`.
  - **Incorrecto**: `public void MyMethod() {}`
  - **Correcto**: `public void myMethod() {}`
- **PackageName**: Asegura que los nombres de los paquetes estén en minúsculas.
  - **Incorrecto**: `package com.MyPackage;`
  - **Correcto**: `package com.mypackage;`
- **ParameterName**: Verifica que los parámetros de los métodos sigan las convenciones de nombres.
  - **Incorrecto**: `public void myMethod(int SomeParam) {}`
  - **Correcto**: `public void myMethod(int someParam) {}`
- **StaticVariableName**: Asegura que las variables estáticas sigan las convenciones.
  - **Incorrecto**: `private static int StaticCount = 0;`
  - **Correcto**: `private static int staticCount = 0;`
- **TypeName**: Verifica que los nombres de las clases y tipos sean en `CamelCase` y empiecen con una letra mayúscula.
  - **Incorrecto**: `public class testExample {}`
  - **Correcto**: `public class TestExample {}`

---

## 3. **Reglas de Importación**

[Más información](https://checkstyle.sourceforge.io/checks/imports/index.html)

- **AvoidStarImport**: Verifica que no se utilicen importaciones con `*` (importación de todos los miembros de un paquete).

  **Ejemplo**:
    - **Incorrecto**:
      ```java
      import java.util.*;
      ```
    - **Correcto**:
      ```java
      import java.util.List;
      import java.util.Map;
      ```

- **IllegalImport**: Verifica que no se utilicen paquetes no permitidos (como `sun.*`).

- **RedundantImport**: Verifica que no haya importaciones redundantes, es decir, que no se repitan las mismas clases o paquetes.

- **UnusedImports**: Detecta las importaciones que no se están utilizando en el archivo.

---

## 4. Reglas de tamaño

[Más información](https://checkstyle.sourceforge.io/checks/sizes/index.html)

- **MethodLength**: Verifica que los métodos no excedan un número máximo de líneas de código.

- **ParameterNumber**: Verifica que los métodos no tengan un número excesivo de parámetros.

---

## 5. Reglas de espacios en blanco

Reglas relacionadas al manejo del espaciado y la alineación en el código fuente. [Más información](https://checkstyle.sourceforge.io/checks/whitespace/index.html)

- **EmptyForIteratorPad**: Asegura que haya un espacio adecuado antes y después de los `;` en los bucles `for`, entre la inicialización, la condición y la actualización.

- **GenericWhitespace**: Controla el espaciado dentro de las declaraciones genéricas. Asegura que los elementos genericos, como `<T>`, estén correctamente espaciados.

-  **MethodParamPad**: Asegura que no haya espacios adicionales dentro de los paréntesis de los parámetros de los métodos.

- **NoWhitespaceAfter**: Verifica que no haya espacios después de ciertos elementos, como los operadores y los puntos y coma.

- **NoWhitespaceBefore**: Controla que no haya espacios antes de ciertos caracteres, como los paréntesis y operadores.
- 
- **OperatorWrap**: Asegura que los operadores binarios estén correctamente espaciados y alineados. Esto incluye operadores como `+`, `-`, `*`, `&&`, entre otros.

- **ParenPad**: Controla el espaciado dentro de los paréntesis, asegurando que no haya espacios innecesarios.

- **TypecastParenPad**: Garantiza que no haya espacios innecesarios en las conversiones de tipo (casting), como `(int)`.

- **WhitespaceAfter**: Verifica que haya un espacio después de ciertos operadores y palabras clave. Esto incluye asignaciones y operadores binarios.

- **WhitespaceAround**: Controla que haya un espacio adecuado alrededor de los operadores, asignaciones y otros símbolos.

### Ejemplo Incorrecto

```java
public class Ejemplo {
    public static void main(String[] args) {
        for(int i=0;i<10;i++){System.out.println(i);}
        List<Integer> list=new ArrayList<Integer>();
        int x=10+20*5;
        if(x>50)System.out.println("Mayor que 50");
        int[] arr={1,2,3,4};
        int y=(int)arr[0];
    }
}
```

Correcciones en el ejemplo:

*   **EmptyForIteratorPad**: No hay espacios alrededor de los `;` en el bucle `for`.
*   **GenericWhitespace**: No hay espacio alrededor de los `<` y `>`.
*   **MethodParamPad**: No hay espacio después de los paréntesis de los parámetros.
*   **NoWhitespaceAfter**: Hay un espacio innecesario después de la asignación `=` y antes del `;`.
*   **NoWhitespaceBefore**: Hay un espacio antes de los paréntesis en el `if`.
*   **OperatorWrap**: El operador `+` y `*` no están correctamente espaciados.
*   **ParenPad**: Los paréntesis en la condición `if` tienen espacios innecesarios.
*   **TypecastParenPad**: El casting `(int)` tiene un espacio innecesario antes del paréntesis.
*   **WhitespaceAfter**: No hay espacio después de los operadores como `=`.
*   **WhitespaceAround**: No hay espacio alrededor de los operadores `=`, `+`, y `*`.


### Ejemplo Correcto

```java
public class Ejemplo {
    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.println(i);
        }
        List<Integer> list = new ArrayList<Integer>();
        int x = 10 + 20 * 5;
        if (x > 50) {
            System.out.println("Mayor que 50");
        }
        int[] arr = {1, 2, 3, 4};
        int y = (int) arr[0];
    }
}
```

---

## 6. **Reglas de Modificadores**

[Más información](https://checkstyle.sourceforge.io/checks/modifier/index.html)

- **ModifierOrder**: Verifica que los modificadores de clase, método y campo (como `public`, `private`, `static`, `final`, etc.) estén en el orden correcto según las convenciones de Java.
  
  **Ejemplo**:
  - **Incorrecto**:
    ```java
    public static final int MAX_SIZE = 100;
    ```
  - **Correcto**:
    ```java
    public final static int MAX_SIZE = 100;
    ```

- **RedundantModifier**: Verifica que no se utilicen modificadores redundantes, como `public public` o `private final`.

---

## 7. Reglas de Bloques

[Más información](https://checkstyle.sourceforge.io/checks/blocks/index.html)

- **AvoidNestedBlocks**: Verifica que no haya bloques de código (como un `if`, `for`, `while`, etc.) anidados innecesariamente.

  **Ejemplo**:
  - **Incorrecto**:
    ```java
    if (x > 0) {
        if (x < 10) {
            System.out.println("x está entre 0 y 10");
        }
    }
    ```
  - **Correcto**:
    ```java
    if (x > 0 && x < 10) {
        System.out.println("x está entre 0 y 10");
    }
    ```

- **EmptyBlock**: Asegura que no haya bloques vacíos. Es decir, que no existan `{}` sin ningún código adentro.

- **LeftCurly**: Controla la colocación de las llaves de apertura ({). Según esta regla, la llave de apertura debe estar en la misma línea que la declaración del bloque.

  **Ejemplo Incorrecto:**
  
  ```java
  if (x > 0)
  {
      System.out.println("x es positivo");
  }
  ```

  **Ejemplo Correcto:**
  
  ```java
  if (x > 0) {
      System.out.println("x es positivo");
  }
  ```

- **RightCurly**: Controla la colocación de las llaves de cierre (}). La llave de cierre debe estar alineada con la declaración del bloque (por ejemplo, if, for, while), en la misma línea.

  **Ejemplo Incorrecto:**
  
  ```java
  if (x > 0)
  {
      System.out.println("x es positivo");
      }
  ```
  
  **Ejemplo Correcto:**
  
  ```java
  if (x > 0) {
      System.out.println("x es positivo");
  }
  ```

- **NeedBraces**: Asegura que los bloques de código tengan llaves {} aunque solo contengan una línea de código.
  
  **Ejemplo Incorrecto:**
  
    ```java
    if (x > 0)
        System.out.println("x es positivo");
    
    ```
    
    **Ejemplo Correcto:**
    
    ```java
    if (x > 0) {
        System.out.println("x es positivo");
    }
    
    ```

---


## 8. Reglas para problemas comunes

Este archivo describe una serie de reglas de Checkstyle que ayudan a detectar problemas comunes en el código. [Más información](https://checkstyle.sourceforge.io/checks/coding/index.html)

- **EmptyStatement**: Detecta las sentencias vacías, es decir, aquellas que no realizan ninguna acción, como un punto y coma (`;`) sin ningún código.

- **EqualsHashCode**: Asegura que, si una clase sobrescribe el método `equals()`, también sobrescriba el método `hashCode()`.

- **HiddenField**: Detecta los campos de una clase que están definidos pero nunca se usan.

- **IllegalInstantiation**: Detecta la creación de instancias de clases abstractas o interfaces, lo cual no es permitido en Java.

- **InnerAssignment**: Detecta asignaciones dentro de expresiones, lo cual puede generar confusión y errores difíciles de detectar.

- **MagicNumber**: Detecta números "mágicos", es decir, valores literales en el código que no tienen una explicación clara.

- **MissingSwitchDefault**: Detecta cuando un `switch` no tiene una cláusula `default`.

- **SimplifyBooleanExpression**: Detecta expresiones booleanas complejas que pueden simplificarse.

- **SimplifyBooleanReturn**: Detecta métodos que retornan un valor booleano innecesariamente complejo.

---

## 9. Reglas para diseño de clases

Esta categoría de reglas se enfoca en el diseño de clases, asegurando que el código siga buenas prácticas de diseño orientado a objetos. Estas reglas están orientadas a garantizar que el código sea más mantenible, flexible y claro en cuanto a la estructura de clases y su interacción. [Más información](https://checkstyle.sourceforge.io/checks/design/index.html)

- **InterfaceIsType**: Esta regla asegura que las interfaces se utilicen como tipos en lugar de como clases. Según las buenas prácticas de diseño orientado a objetos, las interfaces deben definirse para describir comportamientos comunes, y no para ser utilizadas directamente como clases base.

- **VisibilityModifier**: Esta regla garantiza que los modificadores de visibilidad (`public`, `private`, `protected`) se usen correctamente. Es importante declarar explícitamente la visibilidad de las clases, métodos y campos para garantizar la encapsulación y seguridad del código.

---

## 10. Reglas misceláneas

Esta categoría agrupa diversas reglas adicionales que no encajan específicamente en otras categorías, pero que aún así son importantes para mantener un código limpio, legible y siguiendo buenas prácticas. [Más información](https://checkstyle.sourceforge.io/checks/misc/index.html)

- **ArrayTypeStyle**: Esta regla asegura que los corchetes que indican un arreglo se coloquen junto al tipo de dato, en lugar de junto al nombre de la variable.

  **Ejemplo Incorrecto:**
  
  ```java
  int[] array1;
  String[] array2;
  ```
  
  **Ejemplo Correcto:**
  
  ```java
  int array1[];
  String array2[];
  ```

- **UpperEll**: Esta regla asegura que los literales de tipo `long` se escriban con `L mayúscula` al final, en lugar de `l` (es decir, `100L` en lugar de `100l).
