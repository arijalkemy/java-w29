# SOCIALMELI API 🖥️

API que permite a compradores seguir a sus vendedores favoritos y enterarse de todas las novedades que los mismos  posteen.

# Documentación 📘

En el siguiente apartado encontraras los Endpoints disponibles: 
- `US-0001 POST /users/{userId}/follow/{userIdToFollow}`: Poder realizar la acción de “Follow” (seguir) a un determinado vendedor.
- `US-0002 GET /users/{userId}/followers/count`: Obtener el resultado de la cantidad de usuarios que siguen a un determinado  
vendedor.
- `US-0003 GET /users/{userId}/followers/list`: Obtener un listado de todos los usuarios que siguen a un determinado  vendedor (¿Quién me sigue?).
- `US-0004 GET /users/{userId}/followed/list`: Obtener un listado de todos los vendedores a los cuales sigue un  determinado usuario (¿A quién sigo?).
- `US-0005 POST /products/post`: Dar de alta una nueva publicación.
- `US-0006 GET /products/followed/{userId}/list`: Obtener un listado de las publicaciones realizadas por los vendedores que  
un usuario sigue en las últimas dos semanas.
- `US-0007 POST /users/{userID}/unfollow/{userIdToUnfollow}`:  
Poder realizar la acción de “Unfollow” (dejar de seguir) a un determinado  vendedor.
- `US-0008 GET Ordenamiento alfabético ascendente y descendente de las US-0003 y US-0004:

| **Tipo** | **Endpoint** | **Descripción** |
|----------|--------------|-----------------|
| Seguidores | `/users/{UserID}/followers/list?order=name_asc` | Ordenamiento alfabético ascendente de los seguidores |
| Seguidores | `/users/{UserID}/followers/list?order=name_desc` | Ordenamiento alfabético descendente de los seguidores |
| Seguidos | `/users/{UserID}/followed/list?order=name_asc` | Ordenamiento alfabético ascendente de los seguidos |
| Seguidos | `/users/{UserID}/followed/list?order=name_desc` | Ordenamiento alfabético descendente de los seguidos |

- `US-0009 GET Ordenamiento por fecha ascendente y descendente de la US-0006:`

| **Endpoint** | **Descripción** |
|----------|-------------|
| `/products/followed/{userId}/list?order=date_asc` | Ordenamiento por fecha ascendente de las publicaciones |
| `/products/followed/{userId}/list?order=date_desc` | Ordenamiento por fecha descendente de las publicaciones |

- `US-0010 POST /products/promo-post`:   Llevar a cabo la publicación de un nuevo producto en promoción.
- `US-0011 GET /products/promo-post/count?user_id={userId}`: Obtener la cantidad de productos en promoción de un determinado vendedor.
- `US-0012 (Bonus) GET /products/promo-post/discount?discount={descuento}`: traer todas las ofertas con mas de un determinado descuento.
- `US-0013 (Bonus) GET /products/posts/{seller_id}`: Obtener los Posts de un vendedor en especifico.

# Integrantes 👥👥

- [@Edward Soto](https://github.com/Astrojoinl)
- [@David Narvaez](https://github.com/Art2416)
- [@Holmes Ramirez](https://github.com/HolmesRamirezMELI)
- [@Edwin Pinilla](https://github.com/EFP210)
- [@Jhon Zuniga](https://github.com/JhonSebasZ)
- [@Jose Cruz](https://github.com/jdav1d)




 

