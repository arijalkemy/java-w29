# Crear el índice de zapatillas

echo "Creando índice 'sneakers'..."

curl -X PUT "localhost:9200/sneakers" -H 'Content-Type: application/json' -d '{
  "mappings": {
    "properties": {
      "modelo": { "type": "text" },
      "marca": { "type": "keyword" },
      "color": { "type": "keyword" },
      "talla": { "type": "float" },
      "precio": { "type": "float" },
      "categoria": { "type": "keyword" },
      "material": { "type": "keyword" },
      "stock": { "type": "integer" },
      "fecha_lanzamiento": { "type": "date" },
      "descripcion": { "type": "text" }
    }
  }
}'

echo "Índice creado correctamente"
