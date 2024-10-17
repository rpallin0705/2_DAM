# TEMA 2: Javacript

`En el head se ponen script para declarar funciones porque este script se ejecuta antes de renderizar el body en memoria`

**Vite** -> Sirve para crear esqueletos de aplicaciones, por ejemplo la estructura base de un proyecto Angular

## Node

**npm init** -> para crear un proyecto node      

## Martes 15 de octubre

### Bucle for in

Se utiliza para iterar las propieddades enumerables de un objeto. **Se utiliza para trabajar con objetos, no arrays**

### Bucle for of

Igual que el **for in** pero se utiliza para `iterar sobre el contenido de un array`

## Objetos en javascript

Creación de objetos

```Javascript
const persona = {
    nombre: "Luis",
    apellidos: "Molina",
    edad: 30,

    saludar: function() {
        console.log(`Hola, mi nombre es ${this.nombre}`);
    }
};

console.log(persona.nombre);
```