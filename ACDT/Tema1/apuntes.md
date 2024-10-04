# Notas

   **Proceso**: *Instancia de un proceso en ejecución que guarda todos los datos relacionados al mismo; código, variables, montículo, pila de ejecución...*

## Jueves 26 de septiembre

**Iniciar proyecto Maven** -> [Maven quickstart Archetype](https://maven.apache.org/archetypes/maven-archetype-quickstart/)

**Ejecutar proyecto Maven** -> `mvn exec:java

**ctrl + shift + p (en archivo pom) -> maven add dependency -> codehouse.mojo luego añadir plugin codehouse**

## Para indicar al serializador que se le está pasando un objeto de un tipo de clase

mirar pdf pagina 36 para implementar el serializador

**JABXCOntext de jakarta.xml.bind para el contecto**
**Con el de eclipse te ahorras la configuracion**

`instrospección`-> de una clase es para ver los metodos y atributos de la clase

## Viernes 4 de octubre

### Test Unitarios

* Pruebas de clases
  * Estáticas -> Se realizan sin ejecutar codigo de la app. Puede ser la revisión de código
  * Dinámicas -> Pruebas que requieren la ejecución de código.
     * Caja negra -> Se realizan sin tener en cuenta el funcionamiento de la app
     * Caja Blanca -> Se realizan conociendo el código de la función
* Pruebas funcionales -> Comprueban la funcionalidad del programa
   * Unitarias -> Escritura de casos de prueba para cada función
   * De componentes -> 
   * De integración -> comprueba que las librerías funcionen juntas correctamente
   * De sistema -> Prueba de sistema completo
   * De humo -> simulación de la entrega del software final
   * Alpha -> Cuando el software está en desarrollo para asegurar que se está desarrollando correctamente
   * Beta -> Cuando el sistema, teoricamente, puede ejecutar en un entorno real
   * De regresión -> Pruebas para intentar descubrir cualquier bug

**JUnit** -> Permite la ejecución de tests en java

EXCELAPI -> APP.java para leer archivos excel
EScribe EXcel para escribir