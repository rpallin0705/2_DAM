/* 11. Valor Predeterminado con Elvis: Define una función que recibe un parámetro de tipo String?
y devuelve un String que es el valor del parámetro si no es null, o un valor predeterminado si
es null. Utiliza el operador Elvis (?:) para proporcionar el valor predeterminado.*/

fun main() {
    println(comprobarString("Juan"))
    println(comprobarString(null));
}

fun comprobarString (nombre : String?) : String = 
    nombre ?: "Hola, el nombre era nulo por lo que devuelvo este mensaje";
