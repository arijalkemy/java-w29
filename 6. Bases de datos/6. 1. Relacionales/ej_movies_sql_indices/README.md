# Ejercicio Movies - Índices

## Ejercicio 1

1. **Con la base de datos **“movies”**, se propone crear una tabla temporal llamada “TWD” y guardar en la misma los episodios de todas las temporadas de “The Walking Dead”.**

```sql
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
```

2. **Realizar una consulta a la tabla temporal para ver los episodios de la primera temporada.**

```sql
-- Consulta de todos los episodios de TWD
SELECT id AS 'ID', title AS 'Título', number_episode AS 'Episodio', number_season AS 'Temporada'
FROM TWD;
```

## Ejercicio 2

1. **En la base de datos **“movies”**, seleccionar una tabla donde crear un índice y luego chequear la creación del mismo.**

```sql
-- Crear índice en el title de la tabla 'series'
CREATE INDEX index_title ON series(title);

-- Chequear creación
SHOW INDEXES FROM series;
```

2. **Analizar por qué crearía un índice en la tabla indicada y con qué criterio se elige/n el/los campos.**

Puede ser conveniente indexar el título de la tabla series, ya que puede funcionar como un identificador único en muchas
ocasiones y pueden hacerse muchas consultas basadas en este campo. Por ejemplo, en los puntos anteriores, para llegar al 
ID de la serie 'The Waling Dead' tuve que hacer un JOIN basándome en el title de serie. Este es un ejemplo de que el título 
puede considerarse como identificatorio y puede acelerar significativamente las consultas el hecho de crear un índice en 
este campo.

## Archivo con la resolución

[resolucion.sql](resolucion.sql)