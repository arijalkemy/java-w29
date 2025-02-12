-- Ejercicio 1
CREATE TEMPORARY TABLE TWD
	SELECT e.* FROM episodes e
    JOIN seasons s ON e.season_id = s.id
    JOIN series sr ON sr.id = s.serie_id AND sr.title = 'The Walking Dead';
    
SELECT t.* FROM TWD t JOIN seasons s ON s.id = t.season_id WHERE s.title = 'Primer Temporada';

-- Ejercicio 2
CREATE INDEX mv_title_idx ON movies(title);
-- Una busqueda muy comun es buscar peliculas por sus nombres :)