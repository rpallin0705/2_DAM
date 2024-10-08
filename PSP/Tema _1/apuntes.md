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

## Lunes 7 de septiembre

**Ejercicio nslookup**
`Página 34 pdf procesos en java`
```Java
public class outputStream {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("nslookup");
        pb.redirectOutput(ProcessBuilder.Redirect.INHERIT);
        try {
          // Para leer caracter por caracter
            InputStreamReader isstdin = new InputStreamReader(System.in, "UTF-8");
          // Para leer linea por linea
            BufferedReader brstdin = new BufferedReader(isstdin);

            String linea;
            System.out.println("Introducir nombre del dominio:");
            while ((linea = brstdin.readLine()) != null && linea.length() != 0) {
              // Se inicia el proceso padre
                Process p = pb.start();
                try {
                  // Para obtener la salida de p
                    OutputStream osp = p.getOutputStream();
                  // Para mandar a nslookup caracteres codificados en UTF8  (los dominios)
                    OutputStreamWriter oswp = new OutputStreamWriter(osp, "UTF-8");
                  // Se puede utilizar un PrintWriter, esto omite la linea anterior porque ya va formateado
                    oswp.write(linea);
                    oswp.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                try {
                    p.waitFor();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Introduce nombre de dominio: ");
        } catch (IOException e) {
            System.out.println("Error de E/S");
            e.printStackTrace();
        }
    }
}


```