-- 1. Agregar una película a la tabla movies.
INSERT INTO movies VALUES (22, null, null,  'Orgullo y prejuicio', 7.1, 10, '2005-09-16', 129, null);

-- 2. Agregar un género a la tabla genres.
INSERT INTO genres VALUES (13, NOW(), NOW(), 'Drama Romántico', 13, 1);

-- 3. Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE movies SET genre_id = 13 WHERE id = 22;

-- 4. Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE actors SET favorite_movie_id = 22 WHERE id = 48;

-- 5. Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE copy SELECT * FROM movies;

-- 6. Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM copy WHERE awards < 5;

-- 7. Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT g.* 
FROM genres AS g
JOIN movies AS m ON m.genre_id = g.id;

-- 8. Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT a.* 
FROM actors AS a
JOIN movies AS m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- 9. Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX movie_title_index ON movies(title);

-- 10. Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies; 

-- 11. En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
-- Si partimos como base las consultas realizadas dentro de este archivo no es muy útil crear un índice, 
-- ahora bien si hicieramos muchas consultas sobre el título de la película o sobre otro aspecto de la tabla si se vería la utilidad.

-- 12. ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
-- Basandonos nuevamente en las consultas aquí realizadas sería útil crear un índice en la tabla movies para los awards de la pelicula
-- Ya que tenemos consultas constantes sobre los premios de la misma, ahorraría tiempo de ejecución