-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD”
-- y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.
DROP TEMPORARY TABLE IF EXISTS TWD;

CREATE TEMPORARY TABLE TWD AS
	SELECT e.*, sn.title AS 'season_title', sn.number AS 'season_number'
	FROM episodes e
	INNER JOIN seasons sn ON e.season_id = sn.id
	INNER JOIN series sr ON sn.serie_id = sr.id
	WHERE sr.title = 'The Walking Dead';

SELECT * 
FROM TWD;

-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT * 
FROM TWD t
WHERE t.season_number = 1;

-- En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.
CREATE INDEX idx_episode_id ON TWD(id);

SHOW INDEX FROM TWD

-- Si con frecuencia se buscan episodios usando id, el índice mejora la velocidad de estas búsquedas.