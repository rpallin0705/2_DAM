/* 1. Declaración de variables enteras: Escribe un programa que declare varias variables enteras
(val y var), realiza operaciones básicas con ellas y muestra el resultado en la consola.*/

fun main() {
    var numero1 : Int = 23;
    val producto : Int = 12;
   	var numero2 : Int = 12;
    
    numero1 += producto;
    numero2 += numero1 * producto;
    
    println("Operaciones: ");
    println("numero1 + producto = " + numero1)
    println("numero2 += numero1 * producto = " + numero2)
   
}