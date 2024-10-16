/*2. Declaración de variables reales, booleanas y cadenas: Crea un programa que declare
variables de tipo Double, Float, Boolean y String. Realiza operaciones con estas variables y
muestra los resultados en la consola.
 */

 fun main() {
    var isSunday : Boolean = true;
    var nDecimal : Float = 2.32F;
    var nDecimalDP : Double = 2.31786;
    var cadenaCaracteres : String = "Si, es domingo";

    println("Es domingo?\t" + cadenaCaracteres);
    var numeroNuevo = nDecimal.toDouble() + nDecimalDP;
    println("De que tipo es este numero? " + numeroNuevo);
}