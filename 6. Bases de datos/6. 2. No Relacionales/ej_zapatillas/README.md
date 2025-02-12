# Ejercicio zapatillas deportivas - Elasticsearch

## Consigna

- Se solicita **crear un índice (BBDD)** en Elasticsearch, de zapatillas deportivas, donde se guardará información relacionada a estos productos. 

- Guardar 20 registros en la base de datos creada, considerando los campos que crea necesarios. 

- Comprobar con consultas los registros insertados en la nueva base de datos. 
  - Utilizar como cliente API Rest, la consola Dev Tools de **Kibana** o **Postman** para realizar las operaciones.

## Resolución

### Creación del índice

```json
PUT /zapatillas
{
  "mappings": {
    "properties": {
      "marca": {
        "type": "text"
      },
      "modelo": {
        "type": "text"
      },
      "precio": {
        "type": "float"
      },
      "talla": {
          "type": "keyword"
      }
    }
  }
}
```

### Insertar registros

Carga de un registro (id automático).
```json
POST /zapatillas/_doc
{
  "marca": "Nike",
  "modelo": "Air Max",
  "precio": 150.0,
  "talla": "42"
}
```

Carga de un registro indicando el `id`.
```json
POST /zapatillas/_doc/1
{
  "marca": "Adidas",
  "modelo": "Superstar",
  "precio": 100.0,
  "talla": "40"
}
```

Carga de muchos registros
```json
POST /zapatillas/_bulk
{ "index": { "_id": 2 } }
{ "marca": "Nike", "modelo": "Air Force 1", "precio": 120.0, "talla": "41" }
{ "index": { "_id": 3 } }
{ "marca": "Puma", "modelo": "Clyde", "precio": 85.0, "talla": "43" }
{ "index": { "_id": 4 } }
{ "marca": "Reebok", "modelo": "Club C 85", "precio": 90.0, "talla": "42" }
{ "index": { "_id": 5 } }
{ "marca": "New Balance", "modelo": "574", "precio": 110.0, "talla": "44" }
{ "index": { "_id": 6 } }
{ "marca": "Converse", "modelo": "Chuck Taylor", "precio": 65.0, "talla": "39" }
{ "index": { "_id": 7 } }
{ "marca": "Under Armour", "modelo": "Curry One", "precio": 130.0, "talla": "45" }
{ "index": { "_id": 8 } }
{ "marca": "Asics", "modelo": "Gel-Lyte III", "precio": 100.0, "talla": "40" }
{ "index": { "_id": 9 } }
{ "marca": "Saucony", "modelo": "Jazz Original", "precio": 75.0, "talla": "38" }
{ "index": { "_id": 10 } }
{ "marca": "Vans", "modelo": "Old Skool", "precio": 85.0, "talla": "41" }
{ "index": { "_id": 11 } }
{ "marca": "Fila", "modelo": "Disruptor 2", "precio": 95.0, "talla": "42" }
{ "index": { "_id": 12 } }
{ "marca": "Skechers", "modelo": "D'Lites", "precio": 70.0, "talla": "43" }
{ "index": { "_id": 13 } }
{ "marca": "Jordan", "modelo": "1 Retro", "precio": 160.0, "talla": "44" }
{ "index": { "_id": 14 } }
{ "marca": "Nike", "modelo": "Zoom Fly", "precio": 140.0, "talla": "40" }
{ "index": { "_id": 15 } }
{ "marca": "Adidas", "modelo": "NMD_R1", "precio": 120.0, "talla": "39" }
{ "index": { "_id": 16 } }
{ "marca": "Reebok", "modelo": "Instapump Fury", "precio": 180.0, "talla": "44" }
{ "index": { "_id": 17 } }
{ "marca": "Converse", "modelo": "All Star", "precio": 60.0, "talla": "42" }
{ "index": { "_id": 18 } }
{ "marca": "Puma", "modelo": "RS-X", "precio": 110.0, "talla": "41" }
{ "index": { "_id": 19 } }
{ "marca": "Adidas", "modelo": "Ultraboost", "precio": 180.0, "talla": "43" }
{ "index": { "_id": 20 } }
{ "marca": "New Balance", "modelo": "990v5", "precio": 175.0, "talla": "44" }
```

### Consulta de registros

Consultar por id
```json
GET /zapatillas/_doc/20
```

Consulta de los registros con `marca` igual a `Nike`.
```json
GET /zapatillas/_search
{
  "query": {
    "match": {
      "marca": "Nike"
    }
  }
}
```

Consulta de todos los registros.
```json
GET /zapatillas/_search
{
  "query": {
    "match_all": {}
  }
}
```

### Actualizar un registro

Actualizar el precio de un registro por su `id`.
```json
POST /zapatillas/_update/1
{
  "doc": {
    "precio": 200.0
  }
}
```

### Borrar registros

Borrar un registro por su `id`.
```json
DELETE /zapatillas/_doc/1
```

Borrar registro por query (esta query va a borrar todos)
```json
POST /zapatillas/_delete_by_query
{
  "query":{
    "match_all": {}
  }
}
```