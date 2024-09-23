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

**.let** -> es una función de extensión que permite ejecutar un bloque de código en un contexto seguro.

```kotlin
nombre?.let {
    println("El nombre es: $it")
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