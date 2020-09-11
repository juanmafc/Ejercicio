# Ejercicio 2

Consideraciones a tener en cuenta

## Capa aplicativa:
* Debido a las columnas nullable, se debe tener en cuenta el manejo de los nulls para evitar posibles excepciones de Null Pointer.  
* Uso de cache a nivel aplicación.  
* Limitar la cantidad de registros pedidos en cada request.  

## Esquema de base de datos:
* Nivel de normalización de la tabla. Podría ser preferible tener redundancia para evitar hacer varios JOINS para una consulta y mejorar la performance, teniendo en cuenta el costo en la mantenibilidad de la integridad de los datos.  

## Network:
* El tiempo de latencia. El tiempo se reduciría cuanto más cercanos estén los servidores a los clientes.
* A mayor bandwidth, mejor performance.  
* Configuración del load balancer para evitar sobrecargar a algún servidor.  

## Motor de base de datos:
* Uso de cache a nivel motor de base de datos.  
* Uso de indexación.  

## Hardware:
* Velocidad del disco.  
* Cantidad de memoria RAM y especificaciones de la cache.  
