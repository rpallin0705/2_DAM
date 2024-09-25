Notas
========

INTRODUCCION A KOTLIN
----------------------

Lunes 23 de septiembre
-----------------------


### **Nullables** -> característica de kotlin que permite que una variable tenga un valor nulo.

Declaración de una variable nullable: (?)

```kotlin
var edad: Int? = null
```
Para comprobar si una variable es nullable, se puede usar el **operador Elvis (?)**.

```kotlin
val longitudNombre = nombre?.length ?: 0
println("La longitud del nombre es: $longitudNombre")
```
`nombre?` -> comprueba si nombre es null.

`?:` -> operador Elvis.

`0` -> valor de retorno si nombre es null.

#### **Operador de afirmacion de no nullidad (!!)**

```kotlin
val longitudNombre = nombre!!.length
println("La longitud del nombre es: $longitudNombre")
```
`nombre!!` -> afirma que nombre no es null. `El programador debe asegurarse de que esa variable no va a ser null` Si es null se producirá un error en tiempo de ejecución.

#### **Funciones anullables**

```kotlin
fun obtenerNombre(): String? {
    return null
}

fun obtenerNombreConPredeterminado(): String {
    return obtenerNombre() ?: "Siempre devolverá este String porque el valor predeterminado siempre será null";
}
```

**.let** -> es una función de extensión que permite ejecutar un bloque de código en un contexto seguro. Además tendrá acceso al valor de la variable con el operador `it`.

```kotlin
nombre?.let {
    println("El nombre es: $it")
} ?: run {
    println("El nombre es null")
}
```
$it -> Hace referencia al valor de la variable nombre

**Estructuras de control**
------------------ -----

### **When**

Es equivalente al switch de otros lenguajes

```kotlin
fun main() {
    val dia = 3
    val nombreDia = when (dia) {
        1 -> "Lunes"
        2 -> "Martes"
        3 -> "Miercoles"
        4 -> {"Jueves"}
        else -> {"No es un día de la semana"}
    }
}
```
```kotlin
fun main() {
    val sueldo = 1000
    val impuesto = when (sueldo) {
        in 1..1000 -> 0.1
        in 1001..2000 -> 0.2
        else -> 0.3
    }
    println("El impuesto es: $impuesto")
}
```

`in 1..1000` -> Se usa para dar un rango de valores.


### **For**

```kotlin
fun main() {
    val suma = 0
    for (i in 1..5) {
        print("El número es: $numero")
        val valor = readLine()!!.toInt()
        suma += valor
    }
    println("La suma es: $suma")
}
```

```kotlin
fun main() {
    for (i in 10 downTo 1 step 2) {
        println("El número es: $i")
    }
}
```

`downTo` -> decrementa en lugar de incrementar.

`step` -> permite establecer el tamaño del salto.

## Miercoles 25 de septiembre

ARRAYS
---------------------------------------------

```kotlin
vall arr = IntArray(5)?
val names = arrayOf("Juan", "Pedro", "Maria", "Luisa", "Ana")
```
`arrayOf` -> array inmutable

### Funciones para crear arrays

```kotlin
val arr = intArrayOf(1, 2, 3, 4, 5)
val arr2 = intArrayOf(6, 7, 8, 9, 10)
var arr3 = doubleArrayOf(1.0, 2.0, 3.0, 4.0, 5.0)
val arr4 = Array(5) { it * 2 }
val arr5 = Array(5) { index -> 
    when (index) {
        0 -> 1.4
        1 -> 2.4
        2 -> 3.4
        3 -> 4.4
        4 -> 5.4
        else -> 0.0
    }
}
```
`it*2` -> multiplica cada elemento del array por 2.

`index -> index*2` -> multiplica cada elemento del array por 2.

### Busqueda y filtrado

```kotlin
val myArray = IntArray(20) {it}
val pares = myArray.filter { it % 2 == 0}
val index = myArray.indexOf(3)
val index = myArray.contains(4)
val total = myArray.sum()
val promedio = myArray.average()
val max = myArray.maxOrNull()
val min = myArray.minOrNull()
val sorted = myArray.sorted()
val reversed = myArray.reversed()
val distinct = myArray.distinct()
val groupBy = myArray.groupBy { it % 2 == 0 }

```

`filter(){}` -> filtra los elementos del array que cumplen una condición.

`indexOf()` -> devuelve el índice del primer elemento que cumple una condición.

`contains()` -> devuelve true si el elemento está en el array.

`sum()` -> devuelve la suma de los elementos del array.

`average()` -> devuelve la media de los elementos del array.

`maxOrNull()` -> devuelve el valor máximo del array.

`minOrNull()` -> devuelve el valor mínimo del array.

`sorted()` -> devuelve un array ordenado.

`reversed()` -> devuelve un array invertido.

`distinct()` -> devuelve un array con los elementos distintos.

`groupBy()` -> devuelve un array con los elementos agrupados por una condición.



```kotlin
fun main() {
    val myArray = intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
    val listFromArray = myArray.toList()
    println("Convertido a lista: $listFromArray")

    val mutableListFromArray = myArray.toMutableList()
    mutableListFromArray.add(11)
    println("Lista mutable: $mutableListFromArray")
}
```

`toList()` -> convierte el array en una lista.

`toMutableList()` -> convierte el array en una lista mutable.

```kotlin
fun main() {
    val pairsArray = arrayOf(
        "Santino" to "Mondragón",
        "Juan" to "Perez",
        "Maria" to "Gomez"
    )
    val mapFromPairs = pairsArray.toMap()
    println("Convertido a mapa: $mapFromPairs")
}
```

`toMap()` -> convierte el array de pares en un mapa.

```kotlin
val myArray : Array<Pair<String, Int>> = arrayOf(
    "Santi" to 25,
    "Juan" to 30,
    "Maria" to 28
)
val mapFromPair : Map<String, Int> = myArray.toMap()
mapFromPair.forEach { key, value -> println("$key -> $value") }
```

`Array<Pair<String, Int>>` -> array de pares de string e int.

`Map<String, Int>` -> mapa de string e int.

`forEach{key, value -> println("$key -> $value")}` -> recorre el mapa.

## FUNCIONES

```kotlin
fun saludar(nombre: String) = "Hola, $nombre"
```

```kotlin
fun saludar(nombre: String = "Mensaje por defecto"){
    println("Hola, $nombre")
}
```

`= "Hola, $nombre"` -> función de una sola línea.

`nombre: String = "Mensaje por defecto"` -> Si la funcion no recibe nada retornará el mensaje por defecto

```kotlin
fun devuelveSumaArray(arr: Array<Int>): Int {
    return arr.sum()
}
```

`arr: Array<Int>` -> recibe un array de enteros.

`: Int` -> la función devuelve un entero

`return arr.sum()` -> devuelve la suma de los elementos del array.


# **`HACER PRACTICA 1 KOTLIN MOODLE`**



