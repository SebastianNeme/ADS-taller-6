# Sistema de Gestión de Pedidos de Restaurante

**Pontificia Universidad Javeriana**  
**Materia:** Análisis y Diseño de Software (ADS)  
**Taller Final – Patrones de Diseño**  
**Autores:** Andrés y Sebastián  

---

## Descripción General

Este proyecto implementa un sistema modular para la gestión de pedidos en un restaurante. La solución está construida siguiendo una arquitectura en capas, principios SOLID y la aplicación de patrones de diseño orientados a objetos.  

El sistema busca facilitar la creación, seguimiento y administración de pedidos, permitiendo personalización de ítems y comunicación entre las distintas áreas del restaurante de forma reactiva.

### Patrones de Diseño Aplicados

- **Factory Method (Creacional):** Permite encapsular la creación de distintos tipos de ítems del menú.  
- **Decorator (Estructural):** Facilita la extensión dinámica del comportamiento de los ítems del menú.  
- **Observer (Comportamiento):** Implementa notificaciones automáticas al cambiar el estado de un pedido.  
- **State (Comportamiento):** Modela el ciclo de vida de un pedido, encapsulando su comportamiento en cada estado.

---

## Arquitectura del Proyecto

El sistema está dividido en los siguientes paquetes o capas:

- **domain.model**  
  Contiene las entidades del negocio: `Order`, `Customer`, `MenuItem`, `PlatoPrincipal`, `Bebida`, `Postre`.

- **domain.state**  
  Implementa el patrón State para el control de estados del pedido: `ReceivedState`, `PreparingState`, `ReadyState`, `DeliveredState`.

- **domain.decorator**  
  Incluye decoradores como `ExtraQueso` y `EmpaqueParaLlevar`, que modifican dinámicamente el comportamiento de los objetos `MenuItem`.

- **domain.observer**  
  Define observadores (`CustomerObserver`, `KitchenObserver`) y el sujeto `OrderNotifier` para gestionar los eventos de cambio de estado.

- **domain.factory**  
  Contiene las fábricas concretas (`PlatoFactory`, `BebidaFactory`, `PostreFactory`) que aplican el patrón Factory Method.

- **application**  
  Incluye los casos de uso que coordinan la lógica del negocio: `MenuService`, `OrderService`, `ReportService`.

- **infrastructure**  
  Implementa la persistencia simulada mediante repositorios en memoria: `InMemoryMenuRepository`, `InMemoryOrderRepository`.

- **ui**  
  Proporciona una interfaz de consola (`RestaurantConsoleApp`) para la interacción del usuario con el sistema.

---

## Funcionalidades Principales

- Visualizar el menú de ítems disponibles.  
- Registrar clientes.  
- Crear pedidos personalizados, con decoradores opcionales (como extra queso o empaque para llevar).  
- Avanzar el estado de un pedido y generar notificaciones.  
- Consultar todos los pedidos realizados.  
- Obtener el total acumulado de ventas.  
- Ver los ítems más vendidos.

---

## Ejecución desde Consola

La clase principal `RestaurantConsoleApp` permite ejecutar el sistema desde la línea de comandos. El flujo de trabajo típico es el siguiente:

1. El usuario visualiza el menú.
2. Selecciona ítems y aplica decoradores según preferencia.
3. Se crea y registra el pedido con un cliente.
4. El pedido avanza por los distintos estados y genera notificaciones a cocina y cliente.
5. El usuario puede consultar reportes relacionados con ventas y popularidad de productos.

---

## Estructura del Repositorio

src/
├── application/
│ ├── MenuService.java
│ ├── OrderService.java
│ └── ReportService.java
├── domain/
│ ├── model/
│ │ ├── Order.java
│ │ ├── MenuItem.java
│ │ └── ...
│ ├── state/
│ ├── decorator/
│ ├── observer/
│ └── factory/
├── infrastructure/
│ ├── InMemoryMenuRepository.java
│ └── InMemoryOrderRepository.java
└── ui/
└── RestaurantConsoleApp.java


---

## Principios SOLID Aplicados

- **S (Single Responsibility):** Cada clase tiene una responsabilidad única y clara.  
- **O (Open/Closed):** El sistema está diseñado para ser extendido sin modificar el código existente.  
- **L (Liskov Substitution):** Los decoradores y observadores respetan los contratos de sus interfaces.  
- **I (Interface Segregation):** Interfaces específicas como `MenuItem` y `OrderObserver` están correctamente segregadas.  
- **D (Dependency Inversion):** La lógica del negocio depende de abstracciones, no de implementaciones concretas.

---

## Estado Actual

- Implementación funcional completa.  
- Diseño basado en patrones ampliamente adoptados.  
- Código probado desde la consola.  
- Documentación técnica incluida en este archivo README.

---

## Conclusión

Este sistema demuestra la aplicación práctica de patrones de diseño clásicos en un dominio concreto. Su estructura modular, extensible y mantenible permite adaptarlo fácilmente a nuevas funcionalidades y casos de uso, promoviendo buenas prácticas en el desarrollo de software orientado a objetos.
