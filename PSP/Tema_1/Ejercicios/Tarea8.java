import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Tarea8 {

    /*
     *  1. Probarlo en windows donde el padre espere a que el hijo muera (4 ping)
     *  2. Probarlo en linux, donde el padre muestre 10 ping del hijo y luego lo mate)
     *  3. ¿Qué sucede si en la ejecución del hijo, el padre no lo mata?   
     *      Si el padre no mata al hijo, en linux el hijo se seguirá ejecutando indefinidamente
     *      hasta que se detenga manualmente cerrando la consola o el programa
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

        hijo.waitFor();
        System.out.println("Proceso hijo terminado");

        } catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
