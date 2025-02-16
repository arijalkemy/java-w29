-- Agregar una película a la tabla movies.
INSERT INTO movies (title, rating, awards, release_date, length, genre_id) 
VALUES ('Inception', 8.8, 4, '2010-07-16 00:00:00', 148, 2);

-- Agregar un género a la tabla genres.
INSERT INTO genres (name, ranking, active)
VALUES ('Drama', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 1 WHERE title LIKE "Inception";

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 23 WHERE id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE tt_movies AS
SELECT * FROM movies; 

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM tt_movies WHERE awards < 5;
SELECT * FROM tt_movies;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.*  
FROM genres g  
JOIN movies m ON g.id = m.genre_id  
WHERE m.genre_id IS NOT NULL;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT * 
FROM actors a
JOIN movies m 
ON a.favorite_movie_id = m.id
WHERE m.awards > 3; 

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX i_movies_title ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/* No existe una mejora notabla al tratarse de una tabla con pocas rows. Con menos de 1000 registros, el motor de bdd ya es rápido*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/* podría ser en actor_episode ya que cuanta con 2 FK. Un índice puede mejorar la velocidad del JOIN en futuras consultas.
de igual manera por la cantidad de campos q posee esta tabla (150) no vale la pena usarlo. */