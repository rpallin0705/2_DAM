/**
 * 14 Ejercicios II sobre desestructuración





 */

// a. Desestructura el día, mes y año e imprime la fecha dado el array [‘06’, ‘Octubre’, ‘2021’].
const fecha = ["23", "mayo", 1997];
const [dia, mes, anno] = fecha;
console.log(`Hoy estamos a ${dia} de ${mes} de ${anno}`);

// b. Dado un array de números, desestructura los números en posiciones impares.
const numeros = [1, 2, 3, 4, 5, 6, , 7];
const [, dos, , cuatro, , seis] = numeros;
console.log(dos + " " + cuatro + " " + seis);

// c. Desestructura el primer número, el segundo y el resto en otra variable.
const [primero, segundo, ...otros] = numeros;
console.log(primero + " " + segundo + " " + otros);

// d. Desestructura nombre, apellidos y teléfono del siguiente objeto:
const persona = {
  nombre: "Juan",
  apellidos: "Hernandez",
  telefono: "999888777",
};
const [nombre, apellidos, telefono] = persona;

// e. Cambia el siguiente bucle para desestructurar cada entrada e imprimir llave y valor por separado:
for (const [key, value] of Object.entries(persona)) {
  console.log(`Llave: ${key}, Valor: ${value}`);
}

// f. Dado [{x: 1, y: 2}, {x: 3, y: 4}], desestructura los puntos en las variables x1, y1, x2, y2.
const puntos = [
  { x: 1, y: 2 },
  { x: 3, y: 4 },
];
const [{ x: x1, y: y1 }, { x: x2, y: y2 }] = puntos;

/*g. Crea una función a la que le pasas un único objeto como parámetro con 5 propiedades cua‑
lesquiera, incluida la propiedad nombre y apellidos. Desestructura en la función la propiedad
Luis José Molina Garzón 95 */
function imprimirNombreCompleto({ nombre, apellidos, ...otros }) {
  console.log(`Nombre Completo: ${nombre} ${apellidos}`);
}
const persona2 = { nombre: 'Gloria', apellidos: 'Perez', edad: 22, ciudad: 'Barcelona', pais: 'España' };
imprimirNombreCompleto(persona2)

/*h. Dados dos objetos, combínalos en uno solo utilizando el operador spread. Después, elimina
alguna de las propiedades:*/
const objeto1 = { a: 1, b: 2, c: 3 };
const objeto2 = { d: 4, e: 5, f: 6 };
const objeto3 = { ...objeto1, ...objeto2 }
const {d, ...noD} = objeto3

// i. Crea una función que retorna un array con 3 valores. Usa la función y desestructura los valores:
function devolverArray() {
    return [6 , 7 ,8]
}
const [n1, n2, n3] = devolverArray()

// j. Realiza una clonación profunda de un objeto que contiene otros objetos o arrays como propiedades:
const persona3 = {
    nombre: "Rafa",
    numerosTelefono: {
        fijo: '666777888',
        movil: '111222333'
    }
}
const persona3Clon = JSON.parse(JSON.stringify(persona3))