# Ejercicio 1

El código está escrito en inglés pero manteniendo los nombres y atributos de Pedido en español.

## Estructura de clases:

### PedidosDAO

Clase utilizada para acceder y modificar a la tabla de Pedidos

### BumexMemcached 
Considero a esta cache como una cache genérica ya implementada que sirve para cualquier tipo de objetos.

### PedidosCache
Es una cache especifica de Pedidos, conoce cuáles Pedidos fueron modificados y los marca como dirty.
Mantiene una política para determinar si está al límite de su capacidad.  
Por simplicidad, el límite está hardcodeado.  
Esta estructura podría abstraerse usando Generics

### PedidosRepository
Conoce a PedidosDAO y a PedidosCache. Se encarga de mantener la integridad entre ambos. Determina cuándo se debe actualizar en el DAO los Pedidos que están dirty en la cache.  
Si se quiere updatear un Pedido inexistente no se realiza ninguna modificación. Se podria decidir crear el Pedido (es este caso habria que tener consideraciones con los ids) o lanzar una exception.


### PedidosService
Es el entry point de los requests de los clientes y se encarga de controlar el acceso concurrente al PedidosRepository.  
Considero que el servicio tiene una unica instancia compartida entre los threads
