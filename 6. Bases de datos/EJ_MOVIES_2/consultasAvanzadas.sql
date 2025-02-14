-- Agregar una película a la tabla movies.
INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
VALUES (NOW(), NOW(), 'Ejemplo de Película', 8.5, 2, '2023-10-05', 120, 1);

-- Agregar un género a la tabla genres.
INSERT INTO genres (created_at, updated_at, name, ranking, active)
VALUES (NOW(), NOW(), 'Acción', 13, 1);

-- Asociar a la película del punto 1. En el género creado en el punto 2.
UPDATE movies
set genre_id = 14
WHERE title = 'Ejemplo de Película';

-- Comprobar información
SELECT *
FROM movies
WHERE title = 'Ejemplo de Película';

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors
set favorite_movie_id = 22
WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copy_movies
SELECT *
FROM movies;

-- Mirar contenido tabla temporal
SELECT *
FROM copy_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE
FROM copy_movies
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT  g.id, g.name
FROM genres g
JOIN  movies m ON g.id = m.id
GROUP BY g.id, g.name
HAVING  COUNT(m.id) > 0;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.first_name, a.last_name, m.title, m.awards
FROM actors a
JOIN movies m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX  index_title ON movies(title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX  FROM movies;



