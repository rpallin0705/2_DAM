import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tarea9 {

    /*
     *  A partir del ejercicio anterior y en linux, 
     *  dormir al padre por 3 segundos y transcurridos matar al hijo.
     */
    public static void main(String[] args) {

        try{
        ProcessBuilder pingProcess = new ProcessBuilder("ping", "-n", "4", "8.8.8.8");
        Process hijo = pingProcess.start();

        BufferedReader br = new BufferedReader(new InputStreamReader(hijo.getInputStream()));
        String linea = "";

        while ((linea = br.readLine()) != null) {
            System.out.println(linea);
        }

        System.out.println("Dormimos al padre 3 segundos antes de terminar el programa");
        Thread.sleep(3000);
        hijo.destroy();
        hijo.waitFor();
        System.out.println("Proceso hijo terminado");

        } catch (IOException | InterruptedException e){
            Thread.currentThread().interrupt();
            System.out.println(e.getMessage());
        }
    }
}

