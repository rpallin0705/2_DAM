# NOTAS

## Miercoles 25 de septiembre

### PROCESOS EN JAVA

Todo proceso en java tiene un flujo de entrada y salida.

El flujo de datos de entrada es el origen de los datos y el de salida es el destino de los datos.

* **InputStream** -> Metodos para leer la entrada estándar.
  * `BufferedInputStream` -> Metodos para leer bytes del buffer (área de memoria)
* **OutputStream** -> Metodos para escribir en la salida estándar.
  * `BufferedOutputStream` -> Metodos para escribir bytes en el buffer (área de memoria)
* **Reader** -> Metodos para leer caracteres del buffer (área de memoria)
  * `BufferedReader` -> Metodos para leer caracteres del buffer (área de memoria)
* **Writer** -> Metodos para escribir caracteres en el buffer (área de memoria)
  * `BufferedWriter` -> Metodos para escribir caracteres en el buffer (área de memoria)

## Lunes 30 de septiembre

Cuando dos procesos se comunican entre si, por ejemplo P1 y P2. Las salidas de los procesos no tienen porqué apuntar a la misma dirección de memoria o dispositivo. Para ver como se comunican se utilizan los flujos de entrada y salida. Cuando se utiliza el comando `exec()` se crea un nuevo proceso. y este devuelve un objeto `Process`. **La salida de P2 se puede redirigir a la entrada de P1 en forma de bytes y la entrada de P1 se puede redirigir a la salida de P2 en forma de bytes.** Para leer esa entrada se puede utilizar un BufferReader, Scanner, InputSteam, etc.

```java
Process p = Runtime.getRuntime().exec("cmd /c dir");

// Se optiene el stream de salida del programa
InputStream is = p.getInputStream();

// Se utiliza un bufferedReader para leer la salida, línea por línea, más comodamente
BufferedReader br = new BufferedReader(new InputStreamReader(is));

// Se lee la primera línea
String aux = br.readLine();

// Mientras se haya leido una línea, se imprime por pantalla
while (aux != null) {
    System.out.println(aux);
    aux = br.readLine();
}

br.close();
```

Para crear procesos vamos a utilizar la clase `ProcessBuilder`. En el constructor de la clase se le pasa el comando en forma de argumentos **(array de strings).**

Para devolver un objeto Process se utiliza el comando ```proceso.start()```

## Jueves 3 de octubre

`p.isLive()` -> Comprueba que el proceso esté vivo
`p.waitFor()` -> Espera a que el proceso termine para seguir la ejecución
`p.waitFor(MAX_TIEMPO_EJECUCION, **TimeInit.MILISECONDS**)` -> Espera a que el proceso termine para seguir la ejecución con un lñimite de tiempo. Se le pasa el tiempo máximo a esperar y la unidad de tiempo
