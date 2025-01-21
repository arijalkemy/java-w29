3. Buscar vehículos por marca y rango de años

- Como: Usuario de la API. 
- Quiero: Listar vehículos de una marca específica fabricados en un rango de años. 
- Para: Realizar búsquedas más detalladas en el inventario. 
- Endpoint: GET /vehicles/brand/{brand}/between/{start_year}/{end_year} 
- Respuestas:
  - 200 OK: Devuelve una lista de vehículos que cumplen con los criterios. 
  - 404 Not Found: No se encontraron vehículos con esos criterios.
