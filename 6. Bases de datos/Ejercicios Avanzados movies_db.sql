
-- CREACION TABLA TEMPORAL TWD
DROP TABLE IF EXISTS TWD;
CREATE TEMPORARY TABLE TWD AS
SELECT sr.title AS serie, e.title AS titulo, s.title AS temporada
FROM episodes e
JOIN seasons s ON e.season_id = s.id
JOIN series sr ON s.serie_id = sr.id
WHERE sr.title = 'The Walking Dead';

-- CONSULTA A TABLA TEMPORAL TWD
SELECT serie,titulo,temporada 
FROM twd
WHERE temporada='Primer Temporada';

-- CREACION DE INDICE
CREATE INDEX idx_movies_genre_id ON movies(genre_id);

-- Agregar una película a la tabla movies.
INSERT INTO `movies` (`title`, `rating`, `awards`, `release_date`, `length`, `genre_id`)
VALUES ('Inception',8.8,4,'2010-07-16',148,2);

-- Agregar un género a la tabla genres.
INSERT INTO `genres` (`name`, `ranking`, `active`)
VALUES ('Sci-Fi', 13, 1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
UPDATE `movies`
SET `genre_id` = (SELECT `id` FROM `genres` WHERE `name` = 'Sci-Fi')
WHERE `title` = 'Inception';

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
UPDATE `actors`
SET `favorite_movie_id` = (SELECT `id` FROM `movies` WHERE `title` = 'Inception')
WHERE `id` = 1; 

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE `temp_movies` AS
SELECT * FROM `movies`;


-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
DELETE FROM `temp_movies`
WHERE `awards` < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
SELECT DISTINCT `genres`.*
FROM `genres`
JOIN `movies` ON `genres`.`id` = `movies`.`genre_id`;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
SELECT `actors`.*
FROM `actors`
JOIN `movies` ON `actors`.`favorite_movie_id` = `movies`.`id`
WHERE `movies`.`awards` > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX `idx_movies_title` ON `movies`(`title`);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM `movies`;
-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
Crear índices en la base de datos movies puede mejorar significativamente el 
rendimiento de las consultas que buscan películas por título, género, 
o cualquier otra columna indexada. Los índices permiten que el motor 
de la base de datos localice rápidamente las filas sin tener que 
escanear toda la tabla, lo que es especialmente beneficioso en tablas grandes.
*/

-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
Crearía un índice en la tabla actors sobre las columnas first_name y last_name. 
Esto mejoraría el rendimiento de las consultas que buscan actores por nombre, 
lo cual es una operación común en aplicaciones que manejan datos de actores
*/
