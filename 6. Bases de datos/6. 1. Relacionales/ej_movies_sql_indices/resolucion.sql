-- Ejercicio 1
-- Crear tabla
CREATE TEMPORARY TABLE TWD (
    id INT,
    title VARCHAR(50),
    number_episode INT,
    number_season INT
);

-- Insertar todos los episodios de 'The Walking Dead' en la tabla temporal
INSERT INTO TWD SELECT e.id, e.title, e.number, s.number
FROM episodes e
    JOIN seasons s ON e.season_id = s.id
    JOIN series se ON s.serie_id = se.id
WHERE se.title = 'The Walking Dead';

-- Consulta de todos los episodios de TWD
SELECT id AS 'ID', title AS 'Título', number_episode AS 'Episodio', number_season AS 'Temporada'
FROM TWD;

-- Ejercicio 2
-- Crear índice en el title de la tabla 'series'
CREATE INDEX index_title ON series(title);

-- Chequear creación
SHOW INDEXES FROM series;


