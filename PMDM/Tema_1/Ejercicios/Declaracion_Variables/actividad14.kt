/* 15. Filtrado de Valores Nulos en Listas: Define una función que recibe una lista de String? y
devuelve una lista de String filtrada que contiene solo los elementos no nulos. Utiliza la función
filterNotNull() para obtener la lista de valores no nulos.*/

fun main() {
    println("Ingresa tu nombre completo: ")
    var nombre: String? = null ?: "hola"
    
    var nombreSeparado = nombre!!.split(" ")
    nombreSeparado = nombreSeparado.filterNotNull();
    var nombreP : String? = nombreSeparado.getOrNull(0) ?: "No ha ingresado el nombre"
    var apellido1 : String? = nombreSeparado.getOrNull(1) ?: "No existe el apellido"
    var apellido2 : String? = nombreSeparado.getOrNull(2) ?: "No existe el apellido"
    
    println("${nombreP} ${apellido1} ${apellido2}")
}