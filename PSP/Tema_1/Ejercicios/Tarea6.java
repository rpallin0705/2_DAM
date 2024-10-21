import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tarea6 {
    /*
     * 1. Queremos realizar un programa que haga el comando ls -l > "un_fichero.txt"
     * 2. Para ello, crear un fichero con File al que pasarás su nombre como
     * argumento a nuestro main.
     * 3. Utilizar dos buffer, uno para la redirección del flujo de entrada al padre
     * (lo que le devuelve el proceso hijo al padre)
     * y otro para la escritura en un fichero desde el padre a partir del
     * FileWriter.
     * 4. Para probar nuestro ejemplo, debemos poner algo así ./tarea6 fichero2.txt
     */
    public static void main(String[] args) {

        usage(args);

        try {

            Process p = Runtime.getRuntime().exec(new String[] { "cmd.exe", "/c", "ls", "-l", args[0] });
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    FileWriter fl = new FileWriter(new File(args[1]));) {

                String fichero = "";

                while ((fichero = br.readLine()) != null) {
                    // Line separator
                    // fl.write(fichero + "\n");
                    // Para introducir saltos de linea en windows
                    fl.write(fichero + System.lineSeparator());
                }
            }
            

            p.waitFor();
        } catch (IOException | InterruptedException ioe) {
            Thread.currentThread().interrupt();
            System.out.println(ioe.getMessage());
        }
    }

    private static void usage(String[] args) {
        if (args.length == 0 || args.length > 2) {
            System.err.println("Uso: java Tarea6 <comando> <nombre_fichero>");
            System.exit(1);
        }
    }
}
