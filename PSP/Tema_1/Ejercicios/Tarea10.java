import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tarea10 {
    public static void main(String[] args) {
        usage(args);

        try {
            ProcessBuilder lsProcess = new ProcessBuilder("cmd.exe", "/c", "dir", args[0]);
            Process p = lsProcess.start();
            try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
                    FileWriter fl = new FileWriter(new File(args[1]));) {

                String fichero = "";

                while ((fichero = br.readLine()) != null ) {
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
            System.err.println("Uso: java Tarea6 <directorio> <nombre_fichero>");
            System.exit(1);
        }
    }
}
