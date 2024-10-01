import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Borrar {

    public static void main(String[] args) {
        if (args.length != 4) {
            usage();
        } else if (checkArgs(args)) {

            try {

                List<File> archivosEncontrados = encontrarArchivos(args);

                eliminarArchivos(archivosEncontrados);

            } catch (Exception ioe) {
                System.out.println("Error: " + ioe.getMessage());
            }

        } else {
            usage();
        }

    }

    /**
     * Método que elimina los archivos encontrados
     * 
     * @param archivosEncontrados Lista de los archivos encontrados
     * @throws IOException
     */
    private static void eliminarArchivos(List<File> archivosEncontrados) throws IOException {
        if (archivosEncontrados.isEmpty()) {
            System.out.println("No se han encontrado archivos. Saliendo...");

        } else if (getOpcion()) {
            int archivosEliminados = 0;
            for (File archivo : archivosEncontrados) {
                if (archivo.delete())
                    archivosEliminados++;
            }
            System.out.println("Archivos borrados correctamente. Número de archivos borrados: "
                    + archivosEliminados);

        } else {
            System.out.println("No se han borrado los archivos. Saliendo...");
        }
    }

    /**
     * Método que obtiene la opción del usuario para borrar los archivos encontrados
     * 
     * @param archivosEncontrados Lissta de los archivos encontrados
     * @return Indica true si el usuario desea borrar los archivos y false en caso
     *         contrario
     * @throws NumberFormatException
     */
    private static boolean getOpcion() {
        Scanner sc = new Scanner(System.in);
        int opcion = -1;

        do {
            System.out.println("¿Desea borrar los archivos encontrados? (Sí -> 1 / No -> 0)");
            try {
                opcion = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.err.println("Entrada no válida. Por favor, ingrese 1 para Sí o 0 para No.");
            }
        } while (opcion != 1 && opcion != 0);

        sc.close();
        return opcion == 1;
    }

    /**
     * Método que comprueba los argumentos de entrada
     * 
     * @param args Argumentos de entrada
     * @return Devuelve true si los argumentos son correctos y false en caso
     *         contrario
     */
    private static boolean checkArgs(String[] args) {
        return args[0].equals("-f") && (args[2].equals("-n") || args[2].equals("-e"));
    }

    /**
     * Método que encuentra los archivos en la carpeta especificada
     * 
     * @param argumentos Argumentos de entrada
     * @return Devuelve una lista de los archivos encontrados
     */
    private static List<File> encontrarArchivos(String[] argumentos) {
        File carpetaContenedora = new File(argumentos[1]);
        File[] contenidoCarpeta = carpetaContenedora.listFiles();
        List<File> archivosEncontrados = new ArrayList<>();

        for (File archivoBuscado : contenidoCarpeta) {
            if (archivoBuscado.isFile() && (archivoBuscado.getName().equals(argumentos[3])
                    || archivoBuscado.getName().endsWith('.' + argumentos[3]))) {
                System.out.println("Archivo encontrado: " + archivoBuscado.getAbsolutePath());
                archivosEncontrados.add(archivoBuscado);
            } else if (archivoBuscado.isDirectory()) {
                archivosEncontrados.addAll(encontrarArchivos(argumentos));
            }
        }

        return archivosEncontrados;
    }

    /**
     * Método que muestra el uso del programa
     */
    private static void usage() {
        System.out.println("Uso del programa:");
        System.out.println("java Borrar -f carpeta " +
                "[-n nombre_archivo | -e extension]");
        System.out.println("Ejemplo de uso:");
        System.out.println("java .\\Borrar.java -f .\\prueba\\ -n archivo.java");
        System.out.println("java .\\Borrar.java -f .\\prueba\\ -e java");
    }

}