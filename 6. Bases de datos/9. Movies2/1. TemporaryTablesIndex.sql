-- Ejercicio 1

-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
CREATE TEMPORARY TABLE TWD (episode_title varchar(40), season varchar(40));

INSERT INTO TWD SELECT e.title AS Episodio, s.title AS Temporada
FROM episodes AS e
JOIN seasons AS s ON e.season_id = s.id
JOIN series AS se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

SELECT episode_title
FROM TWD 
WHERE season = 'Primer Temporada';

-- Ejercicio 2
-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
-- Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.
-- Una busqueda frecuente puede ser buscar peliculas por sus nombres para ahorrar tiempo en ejecución podemos crear su index
CREATE INDEX movie_title ON movies(title);


