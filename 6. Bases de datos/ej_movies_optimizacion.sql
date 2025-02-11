USE movies_db;

/* EJERCICIO 1*/

/* 1. Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y 
guardar en la misma los episodios de todas las temporadas de “The Walking Dead”. */

CREATE TEMPORARY TABLE TWD AS
SELECT epi.*, sea.number AS season_number
FROM series ser
JOIN seasons sea ON ser.id = sea.serie_id
JOIN episodes epi ON sea.id = epi.season_id
WHERE ser.title = 'The Walking Dead';


/* 2. Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.*/
SELECT * FROM TWD WHERE season_number = 1;

/* EJERCICIO 2 */
/* 1. En la base de datos “movies”, seleccionar una tabla donde crear un índice 
y luego chequear la creación del mismo. */
CREATE INDEX idx_movies_title ON movies(title);
SHOW INDEXES FROM movies;
/*Este indice permite optimizar la busqueda de peliculas por titulo, la cual es una consulta
que puede llegar a ser bastante frecuente */

EXPLAIN SELECT * FROM movies WHERE title LIKE 'Harry Potter%';

