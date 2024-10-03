import java.io.IOException;

public class Tarea5 {
    public static void main(String[] args) {
        try {
            getPMspaint();
        } catch (IOException | InterruptedException e) {
            /**
             * Para finalizar el hilo de ejecución y evitar perder información que indica
             * que el hilo ha sido interrumpido
             */
            Thread.currentThread().interrupt();
        }

        System.out.println("Saliendo del programa...");
    }

    private static void getPMspaint() throws IOException, InterruptedException {
        Process pMspaint = Runtime.getRuntime().exec(new String[] { "mspaint" });
        pMspaint.waitFor();

    }
}
