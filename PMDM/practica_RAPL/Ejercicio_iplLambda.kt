fun main() {

}

/*
Objetivo: Implementar una función llamada f1 que acepte tres valores de tipo real
y una referencia a una función, que represente la solución a una ecuación de
segundo grado. La función debe calcular las raíces de la ecuación y devolver un
Array de tres posiciones, donde la posición 0 tenga un 1 (siempre y cuando haya
solución con dos valores x1 y x2), tenga un 2 (cuando sólo haya una solución) y
tenga un 0 cuando la ecuación no tenga solución: Os pongo un ejemplo:
*/

fun f1(a: Double, b: Double, c: Double, fsolucion: (Double, Double) -> Unit): Array<Int?> {
    val discriminante = b * b - 4 * a * c
    return when {
        discriminante > 0 -> {
            val x1 = (-b + Math.sqrt(discriminante)) / (2 * a)
            val x2 = (-b - Math.sqrt(discriminante)) / (2 * a)
            
            arrayOf(1, x1.toInt(), x2.toInt())
        }
        discriminante == 0.0 -> {
            val x = -b / (2 * a)
        
            arrayOf(2, x.toInt(), null) // Código 2 cuando hay una única solución
        }
        else -> {
    
            arrayOf(0, null, null) // Código 0 cuando no hay solución
        }
    }
}