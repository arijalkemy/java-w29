# **PLANIFICACIÓN DE PRIMER SPRINT**

## **GRUPO #5**

### **INTEGRANTES**
- Belen Caterina Brinso
- Christian Roberto Bravo Reyes
- Luis Manuel Jaimes Silva
- Roberto Lopez Mendez
- Sebastian Chacon Benitez
- Sergio Andres Marentes Martinez

---

## **SOCIAL MELI**
- **Scrum Master**: Lic. Daniel Futrille

---

## **ESTRUCTURA DE PROYECTO**
- **Controller**
- **Service**
- **Repository**
- **Entity**
- **Dto**
- **Exception**
- **Utils**
    - Clase: `MessageExceptions`

---

## **HERRAMIENTAS DE TRABAJO**
- **Slack**: [Canal del equipo](https://meli.enterprise.slack.com/archives/C089Z4LMGJV)
- **Trello**: [Tablero del proyecto](https://trello.com/b/CZHJyYxD)
- **Postman**: [Workspace de Postman](https://app.getpostman.com/invite-signup?invite_code=dde4d9a9a9f301a7ecda9a3e42dff0870f5003f11aaa084b0920e8c26b038fc7)

---

## **REPOSITORIO GITHUB**
[be_java_hisp_w29_g5](https://github.com/samarentes/be_java_hisp_w29_g5)

---

## **DECLARACIÓN DE MODELOS**
- **User**
- **Post**
- **Product**
- **Follow**

---

## **MODO DE TRABAJO PARA DESARROLLO DE REQUERIMIENTOS**
Con el objetivo de optimizar la distribución de tareas en nuestro equipo, hemos decidido categorizar las mismas en tres niveles de dificultad: **1. Fácil**, **2. Medio**, y **3. Difícil**.  
Esta clasificación permite asignar una puntuación a cada tarea, facilitando una evaluación más equitativa del esfuerzo requerido.

Para fomentar el aprendizaje y la colaboración, hemos formado **duplas de trabajo**, compuestas por un miembro con mayor experiencia y otro con menos conocimiento en el área. Esta estrategia garantiza que cada dupla cuente con una mezcla equilibrada de habilidades y conocimientos, promoviendo un desarrollo más efectivo y enriquecedor para ambos miembros.

Las tareas se gestionan mediante [Trello](https://trello.com/b/CZHJyYxD), donde se realiza el seguimiento del progreso de cada integrante del equipo. Esta herramienta proporciona una visión clara del avance en las tareas asignadas, asegurando que todos estemos alineados y comprometidos con nuestros objetivos comunes.

---

## **MODO DE TRABAJO COLABORATIVO - CODE**
Se definió una estructura de trabajo basada en **ramas** para garantizar un desarrollo ordenado y eficiente:
1. Partimos de la rama principal (**main**).
2. Desde **main**, se crea una rama secundaria llamada **develop**.
3. A partir de **develop**, se generan ramas específicas para cada caso de uso, nombradas según el formato **US_0001**.

Este enfoque minimiza los conflictos al realizar Pull Requests (**PR**), asegurando que los cambios que se integren a la rama principal estén completamente depurados y listos para producción.

---

## **REVISIÓN DE CODE**
Para llevar a cabo la revisión de los pull requests (PR), se estableció un esquema de trabajo colaborativo entre pares. En este proceso, los miembros de la dupla se encargan de revisar los PR de los compañeros de otra dupla, facilitando así una revisión mutua. Durante esta actividad, uno de los miembros deja comentarios y observaciones, mientras que se notifican los avances a través de Slack. De esta manera, cada par se enfoca en la revisión de los PR de otros, garantizando así una evaluación objetiva y enriquecedora.

### **Duplas**
- **Dupla 1**:
    - Belen Caterina Brinso
    - Christian Roberto Bravo Reyes

- **Dupla 2**:
    - Sebastian Chacon Benitez
    - Roberto Lopez Mendez

- **Dupla 3**:
    - Luis Manuel Jaimes Silva
    - Sergio Andres Marentes Martinez

---

## **MEJORAS REALIZADAS**
- Se implementó un mensaje de excepción personalizado para **IOException** en los repositorios al cargar los JSON.
- Se añadió una validación de excepción de tipo **NotFound** para los endpoints que reciben **userId** de entrada, mejorando el control.
- Se validó que un vendedor no pueda seguir a otro vendedor.
- Se agregó una validación de orden no válido a la **US_0008**.
