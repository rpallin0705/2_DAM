import java.io.IOException;

public class Tarea51 {
    public static void main(String[] args) {
        try {
            getPMspaint();
        } catch (IOException | InterruptedException e) {
            
            // Para finalizar el hilo de ejecución y evitar perder información sobre la interrupción del hilo
            Thread.currentThread().interrupt();
        }

        System.out.println("Saliendo del programa...");
    }

    private static void getPMspaint() throws IOException, InterruptedException {
        Process pMspaint = Runtime.getRuntime().exec(new String[] { "mspaint" });
        pMspaint.waitFor();

    }
}
