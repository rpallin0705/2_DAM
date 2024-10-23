// a. Crea un array “datos” vacío con un literal.
let datos = [];

// b. Añade a “datos” los números del 1 al 50 con un bucle for.
for( let i = 0; i < 50 ; i++ ) {
    datos.push( i + 1 );
}

// c. Elimina los elementos del 25 al 50 asignando un nuevo tamaño a la propiedad length.
datos.length = 25;

// d. Usa el operador spread para hacer una copia del array anterior.
let  datos2  = [...datos]
console.log( datos2.length)

// e. Crea un array de tamaño 50 con el constructor Array.
let array = new Array(50);

// f. Copia el array anterior a otro con la factoría from.
let copiaArray = Array.from(array);

// g. Crea un array multidimensional de 10 filas (i) y 10 columnas (j). Inicializa cada celda con el valor i*j.

let arrayBidimensiona = []
for (let i = 0; i < 10; i++) {
    let row = [];
    for (let j = 0; j < 10; j++) {
        row.push( i, j );        
    }
    arrayBidimensiona.push( row ); 
} 

// h. Crea un array con la factoría of con los números del 1 al 5. Después, añade un elemento en la
// posición 10 y otro en la 50. Recorre el array con un for imprimiendo los valores, y después con
// forEach. ¿Cuál es la diferencia? ¿Cuál es el tamaño del array?
let arrayF = Array.of(1, 2, 3, 4, 5)
array[10] = 10
array[50] = 50
console.log(arrayF.length)

// i. Elimina dos elementos con delete.
delete arrayF[2]
delete arrayF[1]

// j. Calcula el producto de todos los números del array “datos” con forEach.
let producto = 1
datos.forEach(value => producto *= value)
console.log(producto);

// k. Cada elemento x del array “datos” debe cambiarse por x*x. Usa forEach.
datos.forEach((value, i) => {
    datos[i] = value * value
})

// l. Crea un nuevo array con map recorriendo cada elemento x de “datos”, donde cada elemento
// sea un string “El valor es: x”. Usa template strings.
let arrayDeMap = datos.map(x => `El valor es: ${x}` )

// m. Crea un nuevo array mediante map que incremente cada elemento de “datos” en 5 unidades.
let arrayDeMap2 = datos.map(x => x + 5 )

// n. Mediante filter, quédate con los números impares en un nuevo array impares.
let arrayFilter = arrayDeMap2.filter(x => x % 2 !== 0)


// o. Usa find para buscar el número 16.
let numero16 = datos.find(x => x === 16)

// p. Usa every para comprobar si todos los números son positivos.
let sonPositivos = datos.every(x => x > 0)

// q. Calcula la sumatoria
let sumatoria = datos.reduce((prev, next) => prev + next, 0);
console.log(sumatoria)

// r. Calcula el valor más pequeño del array mediante reduce.
let valorMinimo = datos.reduce((acc, value) => (value < acc ? value : acc), datos[0]);

// s. Usa flat para aplanar el array multidimensional que creaste anteriormente.
let arrayAplanado = arrayBidimensiona.flat()

// t. Tenemos la cadena: “Vamos a usar flatMap. Es igual que map. Pero aplana los arrays”. Separa
// mediante split las distintas frases. Después, mediante map, quita los espacios sobrantes (trim).
// A continuación, usa flatMap para extraer todas las palabras de cada frase en un único array.

let string = "Vamos a usar flatMap. Es igual que map. Pero aplana los arrays"
let stringSeparado = string.split(". ")
let palabra = stringSeparado.flatMap(frase => frase.trim().split(" "));
console.log(palabra)       

/*
u. Crea el array a = [1,2,3,4,5] y b = [6,7,8,9,10] con literales. Concatena los arrays a y b con concat.
Después, usa el operador spread. Crea una variable const cola. Usa unshift y shift para añadir y
quitar elementos. Dado el array resultante de la concatenación de a y b, obtén el subarray desde
el índice 2 hasta el penúltimo elemento (slice). Usa splice para quitar los 2 últimos elementos
de un array.
 */

let a = [1,2,3,4,5]
let b = [6,7,8,9,10]
let c = a.concat(b)
const cola = [...c]
cola.unshift(0)
cola.shift()

// v. Rellena con fill un array de 100 elementos con ‑1.
let arrayMenosUno = new Array(100).fill(-1)

// w. Crea un array de cadenas. Busca con indexOf una cadena.
let cadenas = ["1", "2", "3", "4", "5"]
let cadena = cadenas.indexOf("3")

// x. Comprueba si la cadena “hola” está dentro del array anterior.
let hola = cadenas.includes("hola")

// y. Ordena la lista de cadenas anterior de forma alfabética con sort.
let ordenada = cadenas.sort()

// z. Crea un array vacío de 50 posiciones. Con forEach, asigna valores aleatorios entre 0 y 100. Des‑
// pués, ordena con sort de menor a mayor. Cambia y ordena de mayor a menor.
let arrayVacio = new Array(50)
arrayVacio.forEach(e => arrayVacio.push(arrayRandom[index] = Math.floor(Math.random() * 101)))

// aa. Usa reverse para invertir el array anterior.
arrayVacio.reverse()