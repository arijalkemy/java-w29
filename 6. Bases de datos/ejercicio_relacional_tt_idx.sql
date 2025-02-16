USE movies_db; 

/* Ejercicio 1

Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada. */
DROP TABLE TWD; 
CREATE TEMPORARY TABLE TWD AS
SELECT e.*, se.number AS season_number
FROM episodes e
JOIN seasons se ON e.season_id = se.id
JOIN series sr ON se.serie_id = sr.id
WHERE sr.title = "The Walking Dead";  

SELECT * 
FROM TWD 
WHERE season_number = 1;

/* Ejercicio 2

En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos. */

CREATE INDEX idx_episodes_season ON episodes(season_id);
SHOW INDEX FROM episodes;


