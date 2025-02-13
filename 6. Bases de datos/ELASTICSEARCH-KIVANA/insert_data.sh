# Insertar datos de zapatillas

echo "Insertando datos en el índice 'sneakers'..."

# Registro 1
curl -X POST "localhost:9200/sneakers/_doc/1" -H 'Content-Type: application/json' -d '{
  "modelo": "Air Zoom Pegasus 38",
  "marca": "Nike",
  "color": "Negro",
  "talla": 42.5,
  "precio": 129.99,
  "categoria": "Running",
  "material": "Mesh",
  "stock": 45,
  "fecha_lanzamiento": "2024-01-15",
  "descripcion": "Zapatillas de running con tecnología Air Zoom"
}'

# Registro 2
curl -X POST "localhost:9200/sneakers/_doc/2" -H 'Content-Type: application/json' -d '{
  "modelo": "Ultraboost 21",
  "marca": "Adidas",
  "color": "Blanco",
  "talla": 43.0,
  "precio": 179.99,
  "categoria": "Running",
  "material": "Primeknit",
  "stock": 30,
  "fecha_lanzamiento": "2024-02-01",
  "descripcion": "Máxima amortiguación con tecnología Boost"
}'

# Registro 3
curl -X POST "localhost:9200/sneakers/_doc/3" -H 'Content-Type: application/json' -d '{
  "modelo": "Gel-Nimbus 23",
  "marca": "ASICS",
  "color": "Azul",
  "talla": 41.5,
  "precio": 149.99,
  "categoria": "Running",
  "material": "Mesh sintético",
  "stock": 25,
  "fecha_lanzamiento": "2024-01-20",
  "descripcion": "Zapatillas con tecnología GEL para máximo confort"
}'

# Registro 4
curl -X POST "localhost:9200/sneakers/_doc/4" -H 'Content-Type: application/json' -d '{
  "modelo": "Fresh Foam 1080v11",
  "marca": "New Balance",
  "color": "Gris",
  "talla": 44.0,
  "precio": 159.99,
  "categoria": "Running",
  "material": "Fresh Foam",
  "stock": 20,
  "fecha_lanzamiento": "2024-02-10",
  "descripcion": "Amortiguación Fresh Foam para largas distancias"
}'

# Registro 5
curl -X POST "localhost:9200/sneakers/_doc/5" -H 'Content-Type: application/json' -d '{
  "modelo": "Levitate 5",
  "marca": "Brooks",
  "color": "Rojo",
  "talla": 42.0,
  "precio": 139.99,
  "categoria": "Running",
  "material": "DNA AMP",
  "stock": 15,
  "fecha_lanzamiento": "2024-01-25",
  "descripcion": "Retorno de energía DNA AMP"
}'

# Registro 6
curl -X POST "localhost:9200/sneakers/_doc/6" -H 'Content-Type: application/json' -d '{
  "modelo": "Speedflow.1",
  "marca": "Adidas",
  "color": "Amarillo",
  "talla": 43.5,
  "precio": 189.99,
  "categoria": "Fútbol",
  "material": "Speedskin",
  "stock": 18,
  "fecha_lanzamiento": "2024-02-15",
  "descripcion": "Botas de fútbol para máxima velocidad"
}'

# Registro 7
curl -X POST "localhost:9200/sneakers/_doc/7" -H 'Content-Type: application/json' -d '{
  "modelo": "LeBron 19",
  "marca": "Nike",
  "color": "Morado",
  "talla": 45.0,
  "precio": 199.99,
  "categoria": "Basketball",
  "material": "Battleknit",
  "stock": 22,
  "fecha_lanzamiento": "2024-01-30",
  "descripcion": "Zapatillas de baloncesto de alto rendimiento"
}'

# Registro 8
curl -X POST "localhost:9200/sneakers/_doc/8" -H 'Content-Type: application/json' -d '{
  "modelo": "RS-X³",
  "marca": "Puma",
  "color": "Multicolor",
  "talla": 42.5,
  "precio": 119.99,
  "categoria": "Lifestyle",
  "material": "Mesh y cuero sintético",
  "stock": 35,
  "fecha_lanzamiento": "2024-02-05",
  "descripcion": "Zapatillas retro con diseño moderno"
}'

# Registro 9
curl -X POST "localhost:9200/sneakers/_doc/9" -H 'Content-Type: application/json' -d '{
  "modelo": "Wave Rider 25",
  "marca": "Mizuno",
  "color": "Azul marino",
  "talla": 44.5,
  "precio": 144.99,
  "categoria": "Running",
  "material": "Mesh",
  "stock": 28,
  "fecha_lanzamiento": "2024-01-18",
  "descripcion": "Tecnología Wave para una pisada suave"
}'

# Registro 10
curl -X POST "localhost:9200/sneakers/_doc/10" -H 'Content-Type: application/json' -d '{
  "modelo": "Hypervenom 3",
  "marca": "Nike",
  "color": "Verde",
  "talla": 43.0,
  "precio": 169.99,
  "categoria": "Fútbol",
  "material": "Flyknit",
  "stock": 20,
  "fecha_lanzamiento": "2024-02-20",
  "descripcion": "Botas de fútbol para máxima precisión"
}'

# Registro 11
curl -X POST "localhost:9200/sneakers/_doc/11" -H 'Content-Type: application/json' -d '{
  "modelo": "Cloudflow",
  "marca": "On Running",
  "color": "Negro",
  "talla": 42.0,
  "precio": 159.99,
  "categoria": "Running",
  "material": "Mesh técnico",
  "stock": 25,
  "fecha_lanzamiento": "2024-01-22",
  "descripcion": "Tecnología Cloud para una carrera eficiente"
}'

# Registro 12
curl -X POST "localhost:9200/sneakers/_doc/12" -H 'Content-Type: application/json' -d '{
  "modelo": "Nano X1",
  "marca": "Reebok",
  "color": "Gris",
  "talla": 41.5,
  "precio": 129.99,
  "categoria": "Training",
  "material": "Flexweave",
  "stock": 30,
  "fecha_lanzamiento": "2024-02-08",
  "descripcion": "Zapatillas versátiles para entrenamiento"
}'

# Registro 13
curl -X POST "localhost:9200/sneakers/_doc/13" -H 'Content-Type: application/json' -d '{
  "modelo": "Curry 9",
  "marca": "Under Armour",
  "color": "Azul",
  "talla": 44.0,
  "precio": 159.99,
  "categoria": "Basketball",
  "material": "UA Warp",
  "stock": 18,
  "fecha_lanzamiento": "2024-01-28",
  "descripcion": "Zapatillas de baloncesto profesionales"
}'
