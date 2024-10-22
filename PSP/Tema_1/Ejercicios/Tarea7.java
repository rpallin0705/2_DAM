import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;

public class Tarea7 {
    /*
     * 1. Utilizar un BufferedReader y un FileReader, para volver a otro fichero el
     * contenido del
     * pasado como argumento. Haremos lo siguiente:
     * 2. Pasaremos como argumento por la línea de comandos, el nombre de un fichero
     * de texto.
     * 3. Crearemos una copia con el mismo nombre y concatenando un número.
     * Ejemplo. Si el fichero de entrada es fichero.txt, lo que haremos es crear un
     * clon llamado fichero_1.txt.
     */

    public static void main(String[] args) {
        if (args.length == 0 || args.length > 1)
            usage();

        String[] nombreArchivo = args[0].split("\\.");

        try (
                FileReader reader = new FileReader(args[0]);
                BufferedReader br = new BufferedReader(reader);
                FileWriter writer = new FileWriter(new File(nombreArchivo[0] + "_1." + nombreArchivo[1]));) {

            String line = "";

            while ((line = br.readLine()) != null) {
                writer.write(line + "\n");
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }

    public static void usage() {
        System.out.println("Uso: java Tarea7.java <nombre_fichero>");
        System.exit(1);
    }
}
