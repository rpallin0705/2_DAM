/**
 * Clase principal para ejecutar el programa Lanzador.
 * Este programa lanza los procesos Generador y Recogedor,
 * redirigiendo la salida de uno a la entrada del otro, a partir
 * de la redirección de ficheros.
 * 
 * 
 * @author Santiago Rodenas Herraiz
 * @version PSP 24/25
 */


import java.io.File;
import java.io.IOException;

public class Lanzador2 {
    public static void main(String[] args) {

        // Configurar ProcessBuilder para Generador y Recogedor
        ProcessBuilder pbGen = new ProcessBuilder(new String[]{"java", "Generador"});
        ProcessBuilder pbRec = new ProcessBuilder(new String[]{"java", "Recogedor"});

        // Redirigir la salida de Generador a un archivo
        File outputFile = new File("fich_out.txt");
        pbGen.redirectOutput(outputFile);  // Generador escribe en "fich_out.txt"

        // Redirigir la entrada de Recogedor desde el archivo generado por Generador
        pbRec.redirectInput(outputFile);   // Recogedor lee de "fich_out.txt"

        // Redirigir la salida de Recogedor a la consola de Lanzador
        pbRec.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try {
            // Lanzar Generador
            Process pGen = pbGen.start();   // Lanza Generador

            // Esperar a que Generador termine antes de lanzar Recogedor
            int codGen = pGen.waitFor();  // Esperar a que Generador termine
            /*
             * De esta manera, mantenemos el flujo de ejecución correctamente.
             */
            // Verificar si Generador terminó correctamente antes de iniciar Recogedor
            if (codGen == 0) {
                // Lanzar Recogedor después de que Generador ha terminado
                Process pRec = pbRec.start();   // Lanza Recogedor
                int codRec = pRec.waitFor();    // Esperar a que Recogedor termine

                // Verificar el resultado de los procesos
                String salida = (codRec == 0) ? "Todo bien" : "Ejecución errónea en Recogedor";
                System.out.println(salida);
            } else {
                System.err.println("Error en la ejecución de Generador");
            }

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
