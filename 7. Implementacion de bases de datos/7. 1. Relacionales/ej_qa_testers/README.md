# QA Testers

## Consigna

Un tester manual tiene una serie de casos de prueba de los cuales desea llevar un registro para no perder huella de lo ya probado y lo que falta por testear. Para ello, decidió implementar un API Rest que le permita llevar registro en una base de datos de los procesos que va realizando.

Para esto, utilizará la clase TestCase, la cual debe tener los siguientes atributos:

- **Long** id_case
- **String** description
- **Boolean** tested
- **Boolean** tested
- **int** number_of_tries
- **LocalDate** last_update

Por otro lado, la API debe ser capaz de:

1. Crear, recuperar, actualizar y eliminar casos de prueba.
2. Admitir métodos de búsqueda personalizadods según determinados filtros.

Tener como referencia los siguientes end-points:

|Método|URI|Acción|
|--|--|--|
|POST|`/api/testcases/new`|Crear un nuevo caso de prueba|
|GET|`/api/testcases`|Devolver todos los casos de prueba|
|GET|`/api/testcases/{id}`|Devolver un caso de prueba por id|
|PUT|`/api/testcases/{id}`|Actualizar un caso de prueba por id|
|DELETE|`/api/testcases/{id}`|Eliminar un caso de prueba por id|
|filter|`/api/testcases?last_update='dd/mm/yyyy'`|Buscar todos ls casos de prueba que hayan sido actualizados después de una determinada fecha.|