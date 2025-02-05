# ✨ *Social Meli* ✨

## 📢 Introducción
Mercado Libre está en constante evolución y, con el objetivo de ofrecer una experiencia más cercana entre compradores y vendedores, presenta "SocialMeli". Esta innovadora plataforma permitirá a los compradores seguir a sus vendedores favoritos para estar al tanto de todas las novedades. La fecha de lanzamiento se acerca rápidamente, por lo que es esencial la presentación de una versión Beta.

## 🔄 Metodología de trabajo
Durante el desarrollo de este proyecto, nuestro equipo adoptó una metodología ágil que optimiza la gestión de requerimientos y código, permitiendo una colaboración fluida y entrega continua de valor.

### 🛠 Herramientas utilizadas:
#### 📋 Trello
Utilizamos Trello para gestionar los requerimientos del proyecto, lo cual nos permite:

- ✔️ **Organizar tareas y requerimientos** en tableros visuales.
- 🏷️ **Priorizar y asignar tareas** a los miembros del equipo.
- 👀 **Mantener la visibilidad del progreso**, desde la planificación hasta la finalización.

Nuestro flujo de trabajo en Trello se estructura de la siguiente manera:

1. 📥 **Backlog**: Recopilación de todos los requerimientos y tareas pendientes.
2. 📝 **Por Hacer**: Tareas priorizadas y listas para iniciarse.
3. ⚙️ **En Progreso**: Tareas en desarrollo activo.
4. 🔍 **En Revisión**: Tareas completadas que están en proceso de revisión (pull request).
5. ✅ **Completado**: Tareas finalizadas y aprobadas.

#### 🌿 Git Flow
Para la gestión de código fuente y colaborar eficazmente, seguimos la estrategia **Git Flow**. Nuestro esquema de ramas es el siguiente:

- 🌟 **Main**: Contiene el código estable en "producción".
- 🚧 **Develop**: Rama base para nuevas funcionalidades.
- ✨ **Feature/**: Ramas para desarrollo de características específicas.
- 🐞 **Fix/**: Ramas dedicadas a la corrección de errores.

#### 💬 Comunicación y Colaboración
Fomentamos una comunicación constante mediante:

- ☀️ **Reuniones diarias (Daily Stand-ups)**: Para mantener sincronía y detectar impedimentos.
- 💬 **Herramientas de mensajería instantánea**: Uso de Slack para comunicación rápida.

#### 📚 Documentación en Notion
Toda la documentación del proyecto se aloja en **Notion**, lo cual nos permite:

- 🗄️ **Centralizar la información** en un espacio accesible para todo el equipo.
- 🖊️ **Colaborar en tiempo real**, editando y comentando directamente en los documentos.

## 📌 Sprint 1:

### 📂 Documentación

#### 💻 Endpoints

| User Story |  Endpoint  | Responsable |
|:-----|:--------:|------:|
| US 0001   | POST - /users/{userId}/follow/{userIdToFollow} | Pablo Viano |
| US 0002   | GET - /users/{userId}/followers/count  | Erik Jonathan Calvillo |
| US 0003   | GET - /users/{userId}/followers/list | Erik Jonathan Calvillo |
| US 0004   | GET - /users/{userId}/followed/list | Erik Jonathan Calvillo |
| US 0005   | POST - /products/post | Juan Felipe Ladino Lozano |
| US 0006   | GET - /products/followed/{userId}/list | Silvia Juliana Moreno Roa |
| US 0007   | POST - /users/{userId}/unfollow/{userIdToUnfollow} | Pablo Viano |
| US 0008   | GET - /users/{UserID}/followers/list?order=name_asc | Andres Karchesky |
| US 0009   | GET - /products/followed/{userId}/list?order=date_asc | Andres Karchesky |
| US 0010   | POST - /products/promo-post | Brayan Steven Arellano Espinosa |
| US 0011   | GET - /products/promo-post/count?user_id={userId} | Brayan Steven Arellano Espinosa |

#### 🛠️ Modelo Entidad-Relación:

![image](https://github.com/user-attachments/assets/f3148ac4-59c4-4ea9-80c2-d6f4697fa7fb)

## 🔖 Integrantes
- Andres Karchesky
- Brayan Steven Arellano Espinosa
- Erik Jonathan Calvillo Martinez
- Juan Felipe Ladino Lozano
- Pablo Ezequiel Viano
- Silvia Juliana Moreno Roa

## ⚙️ Arquitectura Multicapa
- **Capa de Entidad (entity):** Esta capa contiene las clases que representan los objetos de negocio de la aplicación. Cada clase en esta capa define los atributos de los datos que se manejan.
- **Capa de Repositorio (repository):** Esta capa se encarga de la interacción con la base de datos. Define interfaces y sus implementaciones para realizar operaciones CRUD (Crear, Leer, Actualizar, Eliminar) sobre las entidades.
- **Capa de Servicio (service):** Esta capa contiene la lógica de negocio de la aplicación. Los servicios se encargan de procesar los datos recibidos de los controladores, aplicar las reglas de negocio y llamar a los repositorios. Actúan como intermediarios entre los controladores y los repositorios.
- **Capa de Controlador (controller):** Esta capa maneja las solicitudes HTTP entrantes y las dirige a los servicios apropiados. Define los endpoints de la API y se encarga de la lógica de enrutamiento y respuesta. Los controladores reciben las solicitudes del cliente, llaman a los servicios necesarios y devuelven las respuestas adecuadas.

## 🧑🏻‍💻 Uso de DTOs
Un DTO (Data Transfer Object) es un objeto que se utiliza para transferir datos entre diferentes capas de una aplicación. Los DTOs son útiles para encapsular los datos y reducir el número de llamadas entre el cliente y el servidor, lo que puede mejorar el rendimiento y la eficiencia de la aplicación. Además, ayudan a mantener la separación de preocupaciones y a evitar la exposición directa de las entidades del modelo de dominio

### 📩 Dtos de Request
- **PostRequestDto:** Este DTO encapsula los datos de una solicitud de publicación.
- **ProductRequestDto:** Este DTO encapsula los datos de una solicitud de producto.

### 📨 Dtos de Response
- **FollowersCountDto:** Este DTO encapsula los datos de un vendedor y el conteo de sus seguidores.
- **FollowerDto:** Este DTO encapsula los datos de un seguidor.
- **SellerFollowersDto:** Este DTO encapsula los datos de un vendedor y sus seguidores.
- **FollowedSellerDto:** Este DTO encapsula los datos de un vendedor seguido.
- **UserFollowedSellerDto:** Este DTO encapsula los datos de un usuario y los vendedores que sigue.
- **ResponseMessageDto:** Este DTO encapsula un mensaje de respuesta.
- **RecentPostsResponseDto:** Este DTO encapsula los datos de las publicaciones recientes de un usuario.
- **PromoPostCountDto:** Este DTO encapsula los datos de un usuario y el conteo de productos en promoción.
- **ProductResponseDto:** Este DTO encapsula los datos de un producto.
- **PostResponseDto:** Este DTO encapsula los datos de una publicación.
- **ExceptionDto:** Este DTO encapsula un mensaje de excepción.