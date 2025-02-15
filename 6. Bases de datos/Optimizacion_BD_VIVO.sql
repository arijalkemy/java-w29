CREATE TEMPORARY TABLE TWD
	SELECT episodes.* FROM episodes
    JOIN seasons ON episodes.season_id = seasons.id
    JOIN series ON series.id = seasons.serie_id AND series.title = 'The Walking Dead';
    
SELECT t.* FROM TWD t JOIN seasons s ON s.id = t.season_id WHERE s.title = 'Primer Temporada';

CREATE INDEX ac_first_name_idx ON actors(first_name);

INSERT INTO movies VALUES (22, NULL, NULL, 'Gato con botas', 9.8, 20, '2023-11-09 00:00:00', 180, NULL);

INSERT INTO genres VALUES (13, NOW(), NOW(), 'Ultra_animation', 13, 1);

UPDATE movies SET genre_id = 13 WHERE id = 22;

UPDATE actors SET favorite_movie_id = 22 WHERE id = 48;