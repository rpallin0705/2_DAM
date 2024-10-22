import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Tarea16 {
    /*
     * Modificar el ejemplo del nslookup visto en clase (el de la presentación),
     * utilizando las clases Scanner y PrintWriter. Utilizar la redirección de
     * salida, para que ambos procesos escriban en pantalla.
     * 
     * Que el hijo herede la salida del padre, para ver en todo momento lo que
     * sucede.
     * Utilizar la clase Scanner, para leer desde teclado los dominios que el padre
     * debe pasar al hijo.
     * Utilizar el PrintWriter, para conectar la salida del padre con la entrada del
     * hijo. (Para pasarle los dominios)
     */
    public static void main(String[] args) {
        ProcessBuilder nslProcess = new ProcessBuilder("nslookup");
        nslProcess.redirectOutput(ProcessBuilder.Redirect.INHERIT);

        try (Scanner scanner = new Scanner(System.in)) {
            String line;
            System.out.println("Introducir nombre del dominio (presione Enter para salir):");

            do {
                line = scanner.nextLine();

                
                    Process process = nslProcess.start();
                    writeOutput(line, process);

                    readProcessOutput(process);

                    waitProcess(process);
                
            } while (!line.isEmpty());

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void writeOutput(String line, Process process) {
        try (PrintWriter writer = new PrintWriter(process.getOutputStream())) {
            writer.println(line); 
            writer.flush(); 
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private static void waitProcess(Process process) {
        try {
            process.waitFor();
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
            System.out.println(ex.getMessage());
        }
    }

    private static void readProcessOutput(Process process) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
            String outputLine;
            while ((outputLine = reader.readLine()) != null) {
                System.out.println(outputLine);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
