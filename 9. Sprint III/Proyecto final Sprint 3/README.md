## User Story 6

**User Story Code:** `ml-product-orders-statistics`  
**User Story Name:** Estadísticas de órdenes de compra  
**Horas Estimadas:** 8

**Descripción de la Historia de Usuario:**  
Como Representante, quiero acceder a las estadísticas de órdenes de compra de los últimos 30 días para entender las preferencias y tendencias de los clientes, de manera que pueda optimizar el stock y seleccionar nuevos productos que se alineen más con los intereses del mercado.

## Escenario 1: Producto de un Seller está registrado

- **Dado que** el producto de un Seller está registrado y que el warehouse es válido y que el representante pertenece al warehouse
- **Cuando** el representante solicita estadísticas
- **Entonces** se muestra la cantidad de productos en órdenes de los últimos 30 días y los 5 productos más ordenados

### Validación

- Autenticarse como seller y acceder a los endpoints.
- Validación de parámetros requeridos.
- La información debe ser de la warehouse del representante.

### Response

- **Status Code:** 200 OK
- **Body:**

  ```json
  {
    "products_ordered": "Integer",
    "top_products": [
      {"name": "String", "id": "Integer", "total_quantity": "Integer"},
      {"name": "String", "id": "Integer", "total_quantity": "Integer"},
      {"name": "String", "id": "Integer", "total_quantity": "Integer"}
    ]
  }

### Endpoint de API
- HTTP Method: GET
- URI: /api/v1/fresh-products/statistics
- Descripción: Ver estadísticas de los últimos 30 días