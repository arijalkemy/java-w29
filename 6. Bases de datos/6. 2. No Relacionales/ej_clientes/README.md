# Clientes - Elasticsearch

## Consigna

No hay consigna así que me voy a inventar algunas consultas.

#### Obtener el mapping de la tabla clientes

```json
GET /clientes/_mapping
```

#### Obtener todos los clientes (match_all)

```json
GET /clientes/_search
{
  "query": {
    "match_all": {}
  }
}
```

#### Obtener los clientes que tengan un nombre que contenga "Juan" (match)

```json
GET /clientes/_search
{
  "query": {
    "match": {
      "column3": "Juan"
    }
  }
}
```

#### Obtener clientes que tengan un nombre que contenga "Juan" y que sean de la localidad "Posadas" (bool)

El `bool` es para combinar condiciones, y el `must` es una especia de AND.

```json
GET /clientes/_search
{
  "query": {
    "bool": {
      "must": [
        {
          "match": {
            "column3": "Juan"
          }
        },
        {
          "match": {
            "column5": "Posadas"
          }
        }
      ]
    }
  }
}
```

#### Obtener todos los clientes ordenados por nombre (sort)

```json
GET /clientes/_search
{
  "sort": [
    {
      "column3": {
        "order": "asc"
      }
    }
  ]
}
```

#### Obtener reporte de cantidad de clientes por localidad (aggs)

Pongo `"size": 0` para que solo me devuelva el resultado de la agregación, no registros individuales.

```json
GET /clientes/_search
{
  "size": 0,
  "aggs": {
    "clientes_por_localidad": {
      "terms": {
        "field": "column5"
      }
    }
  }
}
```

#### Obtener cliente por id

```json
GET /clientes/_doc/05hJ95QBLCeV6x_ndn6J
```

#### Crear un cliente sin indicar el id

Elasticsearch genera automáticamente un ID único.

```json
{
POST /clientes/_doc
    "column1": "2123",
    "column2": "Cordoba",
    "column3": "Agostina",
    "column4": "Avalle",
    "column5": "AR"
}
```

#### Crear un cliente indicando el id

Si uso `PUT` se crea siempre un nuevo documento, si uso `POST` reemplaza el documento con el id indicado en caso 
de que ya exista.

```json
POST /clientes/_doc/1
{
    "column1": "2123",
    "column2": "Cordoba",
    "column3": "Agostina",
    "column4": "Avalle",
    "column5": "AR"
}
```

#### Borrar un cliente por id

```json
DELETE /clientes/_doc/1
```

#### Consultar la existencia de un cliente por id

Devuelve `200 OK` si existe, `404 Not Found` si no.

```json
HEAD /clientes/_doc/1
```

#### Actualizar un cliente por id

Al usar `POST` con `_update` actualiza campos del documento sin reemplazarlo completamente.

```json
POST /clientes/_update/1
{
  "doc": {
    "column3": "Agustina"
  }
}
```
