USE movies_db;

CREATE TEMPORARY TABLE TWD (
    SELECT 
		E.title,
		E.number AS nro_episodio,
		E.release_date,
		E.rating,
		E.season_id,
		SA.number AS nro_temporada
	FROM Series SE
	JOIN Seasons SA ON SE.id = SA.serie_id
	JOIN Episodes E ON SA.id = E.season_id
	WHERE SE.title = 'The Walking Dead'
);

-- Episodios de la primera temporada.
SELECT * FROM TWD WHERE nro_temporada = 1;

CREATE INDEX idx_movie_title ON movies (title);