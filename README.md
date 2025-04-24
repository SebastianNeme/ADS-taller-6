# Sistema de Gestión de Pedidos de Restaurante

Este proyecto corresponde al desarrollo del taller de Diseño y Arquitectura de Software de la Pontificia Universidad Javeriana. El sistema implementa una arquitectura por capas y aplica tres patrones de diseño: Factory Method, Decorator y Observer.

El objetivo es construir un sistema modular, extensible y de bajo acoplamiento, siguiendo principios SOLID y una estructura de software bien definida.

## Estructura del documento

A continuación se describe cada una de las tareas principales del sistema, el responsable de su implementación y un espacio para su documentación correspondiente.

## 1. Estructura base del proyecto  
Responsable: Sebastián

Descripción, organización de paquetes y estructura general del proyecto.

Documentación pendiente

## 2. Gestión del Menú (Factory Method)  
Se implementó la gestión del menú utilizando el patrón de diseño Factory Method, tal como se presenta en el ejemplo del sistema de biblioteca del recurso “Guía Paso a Paso: Creación de un Sistema de Gestión de Biblioteca en Java”.

Se creó la interfaz MenuItem para representar cualquier ítem del menú (plato, bebida o postre), y clases concretas PlatoPrincipal, Bebida y Postre que implementan dicha interfaz.

El patrón Factory Method se aplicó mediante la interfaz MenuItemFactory y sus implementaciones PlatoFactory, BebidaFactory y PostreFactory. Cada fábrica permite crear una instancia de un ítem sin depender directamente de la clase concreta, manteniendo el sistema abierto a extensión y cerrado a modificación (principio O de SOLID).

Los ítems creados se administran a través de la clase MenuService, ubicada en la capa de aplicación. Esta clase permite agregar ítems al menú y listarlos. La funcionalidad fue conectada desde la clase RestaurantConsoleApp, que inicializa un conjunto básico de ítems mediante sus respectivas fábricas y muestra el menú por consola.

La solución respeta la arquitectura por capas y es coherente con el diseño propuesto en el documento “Taller: Diseño y Arquitectura de Software”.

## 3. Creación y Gestión de Pedidos (Decorator)  
Responsable: Sebastián

Creación de pedidos, asignación de ítems, aplicación de extras mediante el patrón Decorator.

Documentación pendiente

## 4. Seguimiento del Estado del Pedido (State)  
Se implementó el seguimiento del estado de los pedidos utilizando el patrón de diseño State, tal como lo propone el documento "Taller: Diseño y Arquitectura de Software". El objetivo fue modelar el ciclo de vida de un pedido como una máquina de estados, permitiendo encapsular la lógica de transición y comportamiento en clases individuales.

Se creó la interfaz OrderState en el paquete domain.state, junto con cuatro clases concretas que representan los estados del pedido: ReceivedState, PreparingState, ReadyState y DeliveredState. Cada clase define su propia transición al siguiente estado.

La clase Order fue modificada para incluir un atributo OrderState, inicializado como ReceivedState en el constructor. Se añadieron los métodos avanzarEstado() y getNombreEstado() para permitir el cambio de estado de forma controlada y consultar el estado actual.

La solución está alineada con el principio O de SOLID (Open/Closed), ya que permite extender los estados sin modificar la lógica de la clase Order, y es coherente con la arquitectura por capas definida en el taller.

## 5. Notificaciones al cambiar el estado (Observer)  
Responsable: Sebastián

Notificación a clientes, cocina o mesero cuando un pedido cambia de estado, usando el patrón Observer.

Documentación pendiente

## 6. Reportes Básicos  
Responsable: Andrés

Generación de reportes simples como lista de pedidos y estadísticas básicas del menú.

Documentación pendiente

## 7. Interfaz de Consola  
Responsable: Andrés

Interfaz textual de interacción con el usuario, menús de navegación y opciones de sistema.

Documentación pendiente

## 8. Documentación del entregable  
Responsable: Andrés y Sebastián

Justificación de la arquitectura, aplicación de los principios SOLID, descripción de los patrones de diseño utilizados, decisiones de diseño y conclusiones.

Documentación pendiente

## Arquitectura general

- `ui`: Capa de presentación (interfaz por consola)
- `application`: Capa de aplicación y servicios (casos de uso)
- `domain`: Capa de dominio (entidades del negocio, lógica central, patrones)
- `infrastructure`: Capa de infraestructura (persistencia en memoria, notificaciones)

## Patrones de diseño aplicados

- Factory Method: creación de ítems del menú.
- Decorator: personalización de ítems del pedido con componentes adicionales.
- Observer: notificaciones automáticas al cambiar el estado de un pedido.

## Principios SOLID

Los principios SOLID se describen con ejemplos específicos en la sección 8 del documento, dentro de la documentación final.

## Estado del proyecto

Este archivo README se encuentra en construcción. Su contenido se actualizará progresivamente a medida que se complete la implementación de cada tarea.
 
