# Elasticsearch

## Ejercicios

### Obtener un cliente por su localidad 

```json
GET clientes/_search
{
  "query": {
    "match": {
      "localidad": "Posadas"
    }
  }
}
```
### Agregar un nuevo usuario
```json
POST clientes/_doc
{
  "localidad": "bogota",
  "pais": "PE",
  "nombre": "Juan Steven",
  "apellido": "Feo Ortiz"
}
```
### Obtener un cliente por su nombre 
```json
GET clientes/_search
{
  "query": {
    "match": {
      "nombre": "Juan Steven"
    }
  }
}
```
### Comprobar que existe un usuario por su Id
retorna un 400 si no existe y un 200 si existe el usuario
```json
HEAD /clientes/_doc/H4QG-5QBOh6RXaPZ4XZr
```
## Archivo con solución
[Solucion](solucion.txt)
