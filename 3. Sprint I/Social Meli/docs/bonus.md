## Documentacion Endpoints Bonus

### Product Controller

### Endpoint: Obtener todos los Productos

**GET** `/products`

#### Descripción
Obtener un listado de todas las publicaciones que se realizaron.

#### Respuesta

```json
{
"post":[
    {
        "user_id": 234,
        "createdAd": "27-01-2025",
        "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
                },
        "category" : 2,
        "price": 12000.00 
        }
    ]
  }
```

### Endpoint: Obtener el post con Id

**GET** `/products/{postId}`

#### Descripción
Obtener el Post con Id igual a postId.

#### Respuesta

```json

{
    "user_id": 234,
    "createdAd": "27-01-2025",
    "product": {
            "product_id": 1,
            "product_name": "Silla Gamer",
            "type": "Gamer",
            "brand": "Racer",
            "color": "Red & Black",
            "notes": "Special Edition"
            },
    "category" : 2,
    "price": 12000.00 
}
    
```

### Endpoint: Eliminar el post con Id

**DELETE** `/products/{postId}`

#### Descripción
Eliminar el Post con Id igual a postId.

#### Respuesta

```json

{
    "Message": "Post delated succesfully"
}
    
```

### Endpoint: Obtener Productos en Promoción

**GET** `/products/promo-post/list?seller_id={sellerId}`

#### Descripción
Obtener un listado de todos los productos en promoción de un determinado vendedor.

---

#### Respuesta

```json
{
    "user_id": 234,
    "user_name": "vendedor1", 
    "posts": [
        {
            "user_id": 234,
            "post_id": 18,
            "date": "29-04-2021",
            "product": {
                "product_id": 1,
                "product_name": "Silla Gamer",
                "type": "Gamer",
                "brand": "Racer",
                "color": "Red & Black",
                "notes": "Special Edition"
            },
            "category": "100",
            "price": 15000.50,
            "has_promo": true,
            "discount": 0.25
        }
    ]
}
```

### User Controller

### Endpoint: Obtener todos los usuarios

**GET** `/users`

#### Descripción
Obtener un listado de todos los usuarios que se crearon.

#### Respuesta

```json
{
"users":[
        {
        "userId": 234,
        "userName": "name"
        }
    ]
}
```

### Endpoint: Obtener el usuario con Id

**GET** `/users/{userId}`

#### Descripción
Obtener el User con Id igual a userId.

#### Respuesta

```json

{
    "userId": 234,
    "userName": "name"
}
    
```

### Endpoint: Eliminar el usuario con Id

**DELETE** `/users/{userId}`

#### Descripción
Eliminar el User con Id igual a userId.

#### Respuesta

```json

{
    "Message": "User delated succesfully"
}
    
```

### Endpoint: Modificar el usuario con Id

**PUT** `/users/{userId}`

#### Descripción
Modificar el User con Id igual a userId.

#### Respuesta

```json

{
  "userId": 234,
  "userName": "name"
}
    
```