/*Uso de let para Procesar Valores No Nulos: Crea una función que reciba un parámetro de tipo
Int?. Si el parámetro no es null, utiliza let para imprimir el doble del valor. Si el parámetro es
null, imprime un mensaje que indique que el valor es null. */

fun main() {
    comprobarInt(5)   // Imprimirá: El doble del valor es: 10
    comprobarInt(null) // Imprimirá: El valor es null
}

fun comprobarInt (numero : Int?) : Unit {
	return numero?.let{
        println("El numero es ${it}")
    } ?: run {
        println("El numero es nulo")
    }
}