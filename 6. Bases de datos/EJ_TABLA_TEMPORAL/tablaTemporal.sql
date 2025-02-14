use movies_db;


-- Crear base de datos temporal WTD
CREATE TEMPORARY TABLE TWD
(
    id             INT,
    title          VARCHAR(50),
    number_episode INT,
    number_season  INT
);


-- Insertar datos en  TWD
INSERT INTO TWD
SELECT e.id     AS episode_id,
       e.title  AS episode_title,
       e.number AS episode_number,
       s.number AS season_number
FROM episodes e
         JOIN seasons s ON e.season_id = s.id
         JOIN series ser ON S.serie_id = ser.id
WHERE ser.title = 'The Walking Dead';

-- Comprobar datos en tabla WTD
SELECT *
FROM TWD;

-- crear indice en titulo de la tabla series
CREATE INDEX index_title ON series(title);

-- mostrar index creado
SHOW INDEX  FROM series;



