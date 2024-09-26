import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Borrar1 {

    public static void main(String[] args) {
        if (args.length != 4) {
            usage();
        } else {
            if (checkArgs(args)) {
                try {

                    File carpetaContenedora = new File(args[1]);
                    List<File> archivosEncontrados = encontrarArchivos(carpetaContenedora, args);
                    getOpcion(archivosEncontrados);

                } catch (Exception ioe) {
                    System.out.println("Error: " + ioe.getMessage());
                }

            } else {
                usage();
            }
        }
    }

    private static void getOpcion(List<File> archivosEncontrados) throws IOException {
        int opcion = 0;
        while ((opcion = System.in.read()) != '\n') {
            if (opcion == '1') {
                for (File archivo : archivosEncontrados) {
                    System.out.printf("Borrado de archivo %s: %B", archivo.getAbsolutePath(), archivo.delete());
                }
                System.out.println("Archivos borrados: " + archivosEncontrados.size());
            }
        }
    }

    private static boolean checkArgs(String[] args) {
        return args[0].equals("-f") && (args[2].equals("-n") || args[2].equals("-e"));
    }

    private static List<File> encontrarArchivos(File carpetaContenedora, String[] argumentos) {
        File[] contenidoCarpeta = carpetaContenedora.listFiles();
        List<File> archivosEncontrados = new ArrayList<>();

        for (File archivoBuscado : contenidoCarpeta) {
            if (archivoBuscado.isFile() && (archivoBuscado.getName().equals(argumentos[3])
                    || archivoBuscado.getName().endsWith('.' + argumentos[3]))) {
                System.out.println("Archivo borrado: " + archivoBuscado.getAbsolutePath());
                archivosEncontrados.add(archivoBuscado);
            } else if (archivoBuscado.isDirectory()) {
                archivosEncontrados.addAll(encontrarArchivos(archivoBuscado, argumentos));
            }
        }

        return archivosEncontrados;
    }

    private static void usage() {
        System.out.println("Uso del programa:");
        System.out.println("java Borrar -f carpeta " +
                "[-n nombre_archivo | -e extension]");
    }

}