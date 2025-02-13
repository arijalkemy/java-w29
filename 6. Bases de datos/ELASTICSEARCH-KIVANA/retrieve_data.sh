# 1. Consultas básicas usando curl

# Ver todos los registros
curl -X GET "localhost:9200/sneakers/_search?pretty"

# Buscar por ID específico
curl -X GET "localhost:9200/sneakers/_doc/1?pretty"

# Buscar por marca
curl -X GET "localhost:9200/sneakers/_search?pretty" -H 'Content-Type: application/json' -d '{
  "query": {
    "match": {
      "marca": "Nike"
    }
  }
}'

# Buscar por rango de precio
curl -X GET "localhost:9200/sneakers/_search?pretty" -H 'Content-Type: application/json' -d '{
  "query": {
    "range": {
      "precio": {
        "gte": 100,
        "lte": 150
      }
    }
  }
}'

# 2. El mismo conjunto de consultas en sintaxis de Dev Tools de Kibana

# Ver todos los registros
curl -X GET "localhost:9200/sneakers/_search" -H 'Content-Type: application/json' -d '
{
  "query": {
    "match_all": {}
  }
}'

# Buscar por marca
curl -X GET "localhost:9200/sneakers/_search" -H 'Content-Type: application/json' -d '
{
  "query": {
    "match": {
      "marca": "Nike"
    }
  }
}'

# Buscar por rango de precio
curl -X GET "localhost:9200/sneakers/_search" -H 'Content-Type: application/json' -d '
{
  "query": {
    "range": {
      "precio": {
        "gte": 100,
        "lte": 150
      }
    }
  }
}'

# 3. Consultas más avanzadas en Dev Tools

# Buscar con múltiples condiciones
curl -X GET "localhost:9200/sneakers/_search" -H 'Content-Type: application/json' -d '
{
  "query": {
    "bool": {
      "must": [
        { "match": { "marca": "Nike" } },
        { "match": { "categoria": "Running" } }
      ]
    }
  }
}
'

# Buscar y ordenar por precio
curl -X GET "localhost:9200/sneakers/_search" -H 'Content-Type: application/json' -d '
{
  "query": {
    "match_all": {}
  },
  "sort": [
    { "precio": "asc" }
  ]
}
'

# Buscar con agregaciones (agrupar por marca)
curl -X GET "localhost:9200/sneakers/_search" -H 'Content-Type: application/json' -d '
{
  "size": 0,
  "aggs": {
    "marcas": {
      "terms": {
        "field": "marca"
      }
    }
  }
}
'