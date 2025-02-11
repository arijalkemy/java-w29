use movies_db;
-- comando para sacar el delete seguro
SET SQL_SAFE_UPDATES = 0; 
select * from movies;
select * from genres;

-- Agregar una película a la tabla movies.
INSERT INTO movies(title,rating,awards,release_date,length,genre_id)values('Avengers',10.0,9,'2023-10-04 00:00:00',240,5);

-- Agregar un género a la tabla genres.
INSERT INTO genres(created_at,name,ranking,active) values('2025-02-11 00:00:00','Super Heroes',13,1);

-- Asociar a la película del punto 1. genre el género creado en el punto 2.
select * from movies;
UPDATE movies set genre_id = 13 where id = 22;

-- Modificar la tabla actors para que al menos un actor tenga como favorita la película agregada en el punto 1.
select * from actors;
UPDATE actors set favorite_movie_id = 22 where id = 1;

-- Crear una tabla temporal copia de la tabla movies.
CREATE TEMPORARY TABLE temp_movies as 
SELECT * FROM MOVIES;
SELECT * FROM temp_movies;

-- Eliminar de esa tabla temporal todas las películas que hayan ganado menos de 5 awards.
SELECT * FROM temp_movies where awards < 5;
DELETE FROM temp_movies
WHERE awards < 5;

-- Obtener la lista de todos los géneros que tengan al menos una película.
select * from movies;
SELECT title, genre_id FROM movies
WHERE genre_id > 1;

-- Obtener la lista de actores cuya película favorita haya ganado más de 3 awards.
select * from actor_movie;
select * from movies;
select * from actors;

SELECT a.first_name,m.awards FROM actors AS a
JOIN movies AS m ON a.favorite_movie_id = m.id
WHERE m.awards > 3;

-- Crear un índice sobre el nombre en la tabla movies.
CREATE INDEX index_movie_title ON movies (title);

-- Chequee que el índice fue creado correctamente.
SHOW INDEX FROM movies;

-- En la base de datos movies ¿Existiría una mejora notable al crear índices? Analizar y justificar la respuesta.
/*
el uso de indices mejora el rendimiento de las consultas, si la tabla tiene muchos registros y se hacen busquedas seguidas sobre los campos
indexados 
*/
-- ¿En qué otra tabla crearía un índice y por qué? Justificar la respuesta
/*
En la tabla actores ya que esta relacionada a movies, y es posible que se busque mucho los actores de X pelicula,
crearia el siguiente index 
CREATE INDEX index_actor_first_name ON actors (first_name);
*/
CREATE INDEX index_actor_first_name ON actors (first_name);
SHOW INDEX FROM actors;

/************************************************************/
-- creo la tabla temporal 
select * from seasons where serie_id = 3; /* serie_id */
SELECT * FROM episodes where season_id IN (select id from seasons where serie_id = 3); /*. */
select * FROM series; /* ID TWD = 3      genre_id = 2 */

CREATE TEMPORARY TABLE TWD as 
SELECT ep.* FROM series s 
INNER JOIN seasons sea ON sea.serie_id = s.id
INNER JOIN episodes ep ON ep.season_id = sea.id
WHERE s.id = 3;

SELECT title /*Traeme el titulo*/
FROM episodes /*De los episodios*/
WHERE season_id in (SELECT id  /*Donde el id*/
	FROM seasons 
	WHERE serie_id = (SELECT id
		FROM series
		WHERE title = 'The Walking Dead') /*Coincida con el id de la serie*/
);

select * from TWD;

CREATE INDEX index_name_serie ON series (title);
SHOW INDEX FROM series;