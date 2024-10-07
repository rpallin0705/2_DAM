import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Tarea52 {
    public static void main(String[] args) {
        /**
         * Desde Ubuntu, Crear un programa con Runtime, que permita mostrar por pantalla
         * toda la información del directorio /etc/init.d pasado como argumento a
         * nuestro programa java. El padre debe mostrar en pantalla la ejecución del
         * hijo con el getInputStream(). Comprobar que el número de parámetros pasados
         * al main, son los correctos. Los que tengáis windows, hacerlo con ruta del
         * tipo c:\<directorio_cualesquiera>
         */

        if (args.length < 1)
            usage();

        try {
            String[] comando = { "cmd.exe", "/c", "dir", "/a", "C:\\" + args[0] };

            Process pDirectorios = Runtime.getRuntime().exec(comando);

            InputStream ipsDirectorios = pDirectorios.getInputStream();

            BufferedReader brDirectorios = new BufferedReader(new InputStreamReader(ipsDirectorios));

            String aux;

            while ((aux = brDirectorios.readLine()) != null) {
                System.out.println(aux);
                aux = brDirectorios.readLine();
                System.out.println(aux);
            }

            pDirectorios.waitFor();

        } catch (IOException e) {
            System.out.println("Saliendo del programa...");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            System.out.println("El proceso se interrumpió");
        }
    }

    public static void usage() {
        System.out.println("Uso del programa:");
        System.out.println("java Tarea51 <Directorio> \"Tiene que estar dentro del disco c:\"");
        System.out.println("java Tarea52 \\usuarios\\tarde");

        System.exit(1);
    }
}
