fun main() {
    var numeroAPedir : Int = readLine()!!.toInt();
    if (numeroAPedir > 0) 
        println("El número es positivo")
    else if (numeroAPedir < 0) 
        println("El número es negativo")
    else
        println("El número es cero")
}