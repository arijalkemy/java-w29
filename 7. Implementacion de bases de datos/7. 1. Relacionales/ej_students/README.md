# Ejercicio prendas para showroom

## Primera parte

La dueña de un showroom desea poder contar con una API que le permita llevar a cabo el control de las prendas que ofrece y vende a cada uno de sus clientes. De cada prenda necesita almacenar los datos: codigo, nombre, tipo, marca, color, talle, cantidad, precio_venta.

A partir de eso, la API debe ser capaz de realizar las siguientes acciones:

|Método|URI| Acción                              |
|---|---|-------------------------------------|
|POST|`/api/clothes`| Crear una nueva prenda.             
|GET|`/api/clothes`| Devolver todas las prendas          |
|GET|`/api/clothes/{code}`| Devolver una prenda en particular   |
|PUT|`/api/clothes/{code}`| Actualizar una prenda en particular |
|DELETE|`/api/clothes/{code}`| Eliminar una prenda en particular   |
|GET|`/api/clothes/{size}`|Traer todas las prendas de un determinado talle|
|GET|`/api/clothes?name=remera`|Buscar todas las prendas en cuyo nombre aparezca la palabra "remera". No se tienen en cuenta mayúsculas ni minúsculas.|

**Nota**: para este ejercicio utilizar una base de datos no relacional.

## Segunda parte

La dueña del Showroom decidió que, además de poder manejar sus prendas, necesita conocer datos de sus ventas y qué productos vendió en ellas. Para ello precisa que en la base de datos se pueda almacenar de cada venta lo siguiente: numero, fecha, total, medio de pago, lista de prendas.

A partir de esto se necesita que la API además de lo realizado en el punto a, ahora también sea capaz de:

|Método| URI                        | Acción                                                       |
|---|----------------------------|--------------------------------------------------------------|
|POST| `/api/sale`                 | Crear una nueva venta.                                       |
|GET| `/api/sale`                 | Devolver todas las ventas.                                   |
|GET| `/api/sale/{number}`        | Devolver una venta en particular.                            |
|PUT| `/api/sale/{number}`        | Actualizar una venta en particular.                          |
|DELETE| `/api/sale/{number}`        | Eliminar una venta en particular.                            |
|GET| `/api/sale?date=22/05/2022` | Traer todas las ventas realizadas en una determinada fecha.  |
|GET| `/api/sale/clothes/{number}` | Traer la lista completa de prendas de una determinada venta. |
