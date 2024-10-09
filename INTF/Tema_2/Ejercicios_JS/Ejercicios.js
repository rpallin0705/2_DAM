/*
a. Crea una cadena multilínea usando comillas dobles.
b. Agrega a la cadena un retorno de carro y tabuladores utilizando los símbolos de escape corres‑
pondientes.
c. Incluye en la cadena el carácter \.
d. Concatena otra cadena utilizando el operador +
e. Concatena cadenas usando un template string. Muestra el valor de varias variables en el tem‑
plate string.
f. Separa un texto que contenga varias frases en un array, donde cada elemento del array sea una
frase.
*/

const multilineString =
  "Esta es la primera línea\n" +
  "esta es la segunda línea\n" +
  "y esta es la tercera línea\n" +
  "\t Esta es la cuarta linea y está tabulada\r";

const stringConcatenada = `Vamos a unir multilineString + ${multilineString}`;

const arrayString = stringConcatenada.split("\n");

console.log(arrayString);

//g. Convierte un texto dado a minúsculas.

arrayString[4] = "SOY UN TEXTO EN MINUSCULAS";
arrayString[5] = arrayString[4].toLowerCase();
console.log(arrayString);

//h. Convierte un texto dado a mayúsculas.

arrayString[3] = arrayString[3].toUpperCase();
console.log(arrayString);

//i. Recorre el texto carácter por carácter usando un bucle e imprímelo.

for (const character of multilineString) {
  console.log(character);
}

//j. Busca una subcadena dentro de un texto.

const subcadenaABuscar = "segunda";

const subcadena = multilineString.slice(
  multilineString.indexOf(subcadenaABuscar),
  multilineString.indexOf(subcadenaABuscar) + subcadenaABuscar.length
);
console.log(`Vamos a buscar la cadena "segunda" -> ${subcadena}`);

//k. Extrae una subcadena desde la posición 3 hasta el final del texto y guárdala en una variable.

const subcadena3 = multilineString.slice(3);
console.log(subcadena3);

//l. Extrae una subcadena desde la posición 3 hasta la primera ocurrencia de una palabra en el texto
//y guárdala en una variable.
const subcadena4 = multilineString.slice(3, multilineString.indexOf("segunda"));
console.log(subcadena4);

//m. Reemplaza todos los espacios en el texto por un guion ‑.
const subcadena5 = multilineString.replaceAll(" ", "-");
console.log(subcadena5);
//n. Elimina los espacios en blanco antes y después del texto.
const subcadena6 = multilineString.trim();
console.log(subcadena6);
//o. Crea una cadena que no contenga ningún espacio partiendo de otra cadena dada.
const subcadena7 = multilineString.replaceAll(" ", "");
console.log(subcadena7)
//p. Crea una función que invierta una cadena de texto.

const invertirCadena = cadenaAInvertir => {
    let cadenaInvertida = "";

    // también se puede hacer con reverse()

    for (let i = cadenaAInvertir.length; i >= 0; i--) {
        cadenaInvertida += cadenaAInvertir[i]; 
    }
    return cadenaInvertida
}

console.log(invertirCadena(multilineString));
//q. Usa una expresión regular para comprobar si la cadena contiene números.

const regexp1 = /\d/;
const cadenaConNumeros = "Hola tengo el numero 5";
const cadenaSinNumeros = "Hola no tengo numeros";
console.log(regexp1.test(cadenaConNumeros));
console.log(regexp1.test(cadenaSinNumeros));
//r. Usa una expresión regular para comprobar si la cadena termina en un punto.
const regexp2 = /\w*\.$/;
const terminaEnPunto = "hola.";
const noTerminaEnPunto = "hola";
console.log(regexp2.test(terminaEnPunto));
console.log(regexp2.test(noTerminaEnPunto));
//s. Usa una expresión regular para comprobar si la cadena comienza con una mayúscula.
const regexp3 = /^[A-Z]/;
const empiezaPorMayus = "Adios muy buenas";
const noEmpiezaPorMayus = "adios muy buenas";
console.log(regexp3.test(empiezaPorMayus));
console.log(regexp3.test(noEmpiezaPorMayus));
//t. Usa una expresión regular para comprobar si la cadena contiene un número de teléfono con
//código internacional.
//u. Reemplaza cualquier ocurrencia de un + seguido de números por la cadena “SECRETO”.