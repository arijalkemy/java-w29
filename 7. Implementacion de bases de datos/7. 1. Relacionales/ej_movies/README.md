# Ejercicio Movies - HQL

## Requerimientos previos para la práctica

### Base de Datos MySQL

- Tener acceso a la base de datos `movies_db.sql` en MySQL. Se adjunta el archivo sql para implementarla.
- Tener un usuario con todos los permisos para la Base de Datos.

### Aplicación del proyecto

- Tener configurado el archivo `pom.xml` con las dependencias necesarias.
- Tener configurado el archivo `application.properties` con la conexión a la BD.
- Tener la estructura del proyecto creada.
- Tener creado el paquete de la capa "model" con sus entidades y DTOs.
- Tener creado el paquete de la capa "repository" con sus interfaces.
- Tener creado el paquete de la capa "service" y sus implementaciones.
- Tener creado el paquete de la capa "controller" y sus endpoints.

## Consignas

### Listar todos los actores que tengan declarada una película favorita. 

`GET /actors/with-fav-movie`

```json
[
    {
        "first_name": "Sam",
        "last_name": "Worthington",
        "favorite_movie": "Avatar"
    },
    {
        "first_name": "Zoe",
        "last_name": "Saldana",
        "favorite_movie": "Titanic"
    },
    {
        "first_name": "Leonardo",
        "last_name": "Di Caprio",
        "favorite_movie": "La Guerra de las galaxias: Episodio VII"
    }
]
```

### Listar todos los actores que tengan rating superior a <valor recibido por parámetro>

`GET /actors/min-rating/{min-rating}`

```json
[
    {
        "first_name": "Sigourney",
        "last_name": "Weaver",
        "rating": 9.7
    },
    {
        "first_name": "Shia",
        "last_name": "LaBeouf",
        "rating": 9.5
    }
]
```

### Listar todos los actores que trabajan en la <película recibida por parámetro>

`GET /actors/movie-title/{title}`

```json
[
    {
        "first_name": "Sam",
        "last_name": "Neill",
        "rating": 2.5
    },
    {
        "first_name": "Laura",
        "last_name": "Dern",
        "rating": 7.5
    },
    {
        "first_name": "Jeff",
        "last_name": "Goldblum",
        "rating": 4.5
    }
]
```

### Listar todas las películas cuyos actores tengan rating superior a <valor recibido por parámetro>

`GET /movies/min-actors-rating/{minRating}`

```json
[
    {
        "title": "Avatar",
        "rating": 7.9,
        "awards": 3,
        "release_date": "2010-10-04",
        "length": 120,
        "genre": "Ciencia Ficcion"
    },
    {
        "title": "Transformers: el lado oscuro de la luna",
        "rating": 0.9,
        "awards": 1,
        "release_date": "2005-07-04",
        "length": null,
        "genre": "Ciencia Ficcion"
    }
]
```

### Listar todas las películas que pertenezcan al <género recibido por parámetro>

`GET /movies/genre/{genreId}`

```json
[
    {
        "title": "Titanic",
        "rating": 7.7,
        "awards": 11,
        "release_date": "1997-09-04",
        "length": 320,
        "genre": "Drama"
    },
    {
        "title": "La vida es bella",
        "rating": 8.3,
        "awards": 5,
        "release_date": "1994-10-04",
        "length": null,
        "genre": "Drama"
    },
    {
        "title": "I am Sam",
        "rating": 9.0,
        "awards": 4,
        "release_date": "1999-03-04",
        "length": 130,
        "genre": "Drama"
    }
]
```

### Listar todas las series que tengan más de <cantidad de temporadas recibida por parámetro>

`GET /series/min-seasons/{minSeasons}`

```json
[
    {
        "title": "Supernatural",
        "release_date": "2005-01-01",
        "end_date": "2016-01-04",
        "number_of_seasons": 12,
        "genre": "Suspenso"
    },
    {
        "title": "The Big Bang Theory",
        "release_date": "2007-01-01",
        "end_date": "2016-01-04",
        "number_of_seasons": 10,
        "genre": "Comedia"
    }
]
```

### Listar todos los episodios (de cualquier serie) donde trabaja un <actor recibido por parámetro>

`GET /actors/episodes/{actorId}`

```json
[
    {
        "serie": {
            "title": "Game of Thrones",
            "release_date": "2011-01-01",
            "end_date": "2016-03-04",
            "number_of_seasons": 7,
            "genre": "Fantasia"
        },
        "seasons": [
            {
                "title": "Primer Temporada",
                "number": 1,
                "episodes": [
                    {
                        "title": "Winter Is Coming",
                        "number": 1,
                        "rating": 7.3,
                        "release_date": "2011-01-01"
                    },
                    {
                        "title": "The Kingsroad",
                        "number": 2,
                        "rating": 8.3,
                        "release_date": "2011-01-01"
                    }
                ]
            },
            {
                "title": "Segunda Temporada",
                "number": 2,
                "episodes": [
                    {
                        "title": "The North Remembers",
                        "number": 1,
                        "rating": 8.3,
                        "release_date": "2012-01-01"
                    }
                ]
            }
        ]
    }
]
```

## Bonus

Implementar nuevas funcionalidades en la API desarrollada, agregando las consultas que se crean necesarias o apropiadas. Se valora la creatividad. Cabe destacar que este punto del ejercicio es OPCIONAL.

### Listar las series y películas donde actúan todos los actores

`GET /actors/works`

```json
[
    {
        "actor": {
            "first_name": "Sam",
            "last_name": "Neill",
            "rating": 2.5
        },
        "movies": [
            "Peaky Blinders",
            "Logan"
        ],
        "series": [
            "Parque Jurasico"
        ]
    },
    {
        "actor": {
            "first_name": "Carrie",
            "last_name": "Fisher",
            "rating": 7.5
        },
        "movies": [],
        "series": [
            "La Guerra de las galaxias: Episodio VI",
            "La Guerra de las galaxias: Episodio VII"
        ]
    }
]
```

### Listar todas las series por género

`GET /series/by-genre`

```json
[
    {
        "genre": "Comedia",
        "series": [
            "The Big Bang Theory",
            "Friends",
            "How I Met Your Mother"
        ]
    },
    {
        "genre": "Drama",
        "series": [
            "Breaking Bad"
        ]
    },
    {
        "genre": "Suspenso",
        "series": [
            "Supernatural",
            "Stranger Things"
        ]
    }
]
```

### Listar todas las películas por género

`GET /movies/by-genre`

```json
[
    {
        "genre": "Animacion",
        "movies": [
            "Buscando a Nemo",
            "Toy Story",
            "Toy Story 2",
            "Intensamente"
        ]
    },
    {
        "genre": "Infantiles",
        "movies": [
            "El rey león",
            "Hotel Transylvania"
        ]
    },
    {
        "genre": "Comedia",
        "movies": [
            "Mi pobre angelito"
        ]
    }
]
```
