-- 1. Agregar una película a la tabla movies.

INSERT INTO movies (created_at, updated_at, title, rating, awards, release_date, length, genre_id)
	VALUES (NOW(), NOW(), 'PeliculaASD', 8.5, 1, '2023-12-25', 120, 1);

-- 2. Agregar un género a la tabla genres.

INSERT INTO genres (created_at, updated_at, name, ranking, active)
	VALUES (NOW(), NOW(), 'GeneroASD', 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.

UPDATE movies
	SET genre_id = (SELECT id FROM genres WHERE name = 'GeneroASD')
	WHERE title = 'PeliculaASD';

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.

UPDATE actors
	SET favorite_movie_id = (SELECT id FROM movies WHERE title = 'PeliculaASD')
	WHERE id = 1;

-- 5. Crear una tabla temporal copia de la tabla movies.

CREATE TEMPORARY TABLE movies_temp SELECT * FROM movies;
SELECT * FROM movies_temp;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards

DELETE FROM movies_temp
	WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.

SELECT DISTINCT g.id, g.name
	FROM genres g
	INNER JOIN movies m ON g.id = m.genre_id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.

SELECT a.id, a.first_name, a.last_name
	FROM actors a
	INNER JOIN movies m ON a.favorite_movie_id = m.id
	WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.

CREATE INDEX name_idx ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.

SHOW INDEX FROM movies;

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.

-- En realidad, si se realizan búsquedas por nombre de manera frecuente sí podría existir una mejora notable ya que la comparación y el filtrado
-- de las movies por su title no se realizaría una a una sino que aprovecharía las ventajas que provee el índice para acceder a la información
-- de manera eficiente.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta

-- En la columna favorite_movie_id de la tabla actors, ya que cuando se realicen búsquedas para obtener las preferencias de los actores se podrían
-- realizar con mayor velocidad permitiendo así, por ejemplo, sugerir películas del mismo género o similares