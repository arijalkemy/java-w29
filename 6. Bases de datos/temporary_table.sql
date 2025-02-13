USE movies_db


-- Con la base de datos “movies”, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.

CREATE TEMPORARY TABLE TWD (
  id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  created_at TIMESTAMP NULL DEFAULT NULL,
  updated_at TIMESTAMP NULL DEFAULT NULL,
  title VARCHAR(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  number INT UNSIGNED DEFAULT NULL,
  release_date DATETIME NOT NULL,
  end_date DATETIME NOT NULL,
  serie_id INT UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

INSERT INTO TWD (created_at, updated_at, title, number, release_date, end_date, serie_id)
SELECT created_at, updated_at, title, number, release_date, end_date, serie_id
FROM seasons
WHERE serie_id = (SELECT id FROM series WHERE title = 'The Walking Dead');


-- Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.
SELECT *
FROM TWD
WHERE number = 1;

-- 1 En la base de datos “movies”, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.

CREATE INDEX idx_seasons_release_date ON seasons (release_date);


-- 2 Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.

-- La razon por la cual decidi crear un indice en la tabla seasons fue para realizar las consultas
-- de la temporadas por la fecha en la que se realizo su lanzamiento, ya que puede ser una consulta
-- frecuente






