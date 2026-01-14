# Reto del Almacén de Arrobas - 1.0

**Arquitectura, estilo MVC (Model-View-Controller) con Patrón Command:**
El proyecto está estructurado para separar claramente los datos de la lógica de negocio y la presentación. En el paquete **model**, la clase `WarehouseMap` actúa como modelo de dominio, encapsulando la matriz del almacén y la lógica geométrica de vecindad y accesibilidad. En el paquete **view**, `ConsoleResultPrinter` se limita a mostrar el total calculado. En **controller**, `WarehouseController` orquesta el flujo: convierte los datos de entrada en el modelo y selecciona el comando adecuado para ejecutar (conteo simple o simulación de purga).

**Principios aplicados:**
* **Responsabilidad Única (SRP):** Cada clase tiene un foco claro. `TextFileReader` solo lee archivos, `WarehouseMap` solo modela el estado del tablero, y los comandos (`CountAccessibleItemsCommand`, `PurgeAccessibleItemsCommand`) encapsulan algoritmos específicos de procesamiento.
* **Inversión de Dependencias (DIP):** El sistema depende de abstracciones (`InputReader`, `SolutionPrinter`, `InventoryCommand`), lo que facilita la sustitución de componentes (por ejemplo, cambiar la entrada de archivo a red) sin afectar al controlador.
* **Abierto-Cerrado (OCP):** El diseño permite extender la funcionalidad. Si se requiere una nueva lógica de inventario (ej. contar elementos aislados), se puede crear una nueva clase que implemente `InventoryCommand` sin modificar el código existente del mapa o del controlador.

**Extras:**
* **Patrón Command:** Se utiliza para encapsular las operaciones de inventario (`Count` y `Purge`), permitiendo que el controlador las ejecute de manera polimórfica.
* **Java Records:** Uso de `WarehouseMap` (como record o clase inmutable conceptualmente) para contener la matriz y sus dimensiones.
* **Streams y Paralelismo:** Uso intensivo de `IntStream`, `flatMap` y `parallel()` para procesar la matriz de manera eficiente, aprovechando la concurrencia para el cálculo de vecindad en matrices grandes.
* **Simulación por Pasos:** Implementación de un bucle de simulación en `PurgeAccessibleItemsCommand` que modifica el estado del modelo iterativamente hasta alcanzar la estabilidad.
