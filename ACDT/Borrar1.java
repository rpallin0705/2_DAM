import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class Borrar1 {

    public static void main(String []args){
        if (args.length!=4) {
            usage();
        } else {
            if(args[0].equals("-f") && (args[2].equals("-n") || args[2].equals("-e"))){
                File carpetaContenedora = new File(args[1]);
                List<String> archivosEncontrados = encontrarArchivos(carpetaContenedora, args);
                int indexArchivo = Integer.parseInt(System.console().readLine());
                
                System.out.println("Archivos borrados: " + encontrarArchivos(carpetaContenedora, args));
            } else {
                usage();
            }
        }
    }

    private static Boolean encontrarArchivos(File carpetaContenedora, String[] argumentos){
        File[] contenidoCarpeta = carpetaContenedora.listFiles();
        List<String> archivosEncontrados = new ArrayList<>();

        for (File archivoBuscado : contenidoCarpeta) {
            if (archivoBuscado.isFile() && (archivoBuscado.getName().equals(argumentos[3]) || archivoBuscado.getName().endsWith('.' + argumentos[3]))) {
                System.out.println("Archivo borrado: " + archivoBuscado.getAbsolutePath());
                archivosEncontrados.add(archivoBuscado.getAbsolutePath());
                    } else if (archivoBuscado.isDirectory()) {
                archivosEncontrados.addAll(encontrarArchivos(archivoBuscado, argumentos));
            }
        }

        return archivosEncontrados;
    }

    private static void usage(){
        System.out.println("Uso del programa:");
        System.out.println("java Borrar -f carpeta " +
            "[-n nombre_archivo | -e extension]");
    }

   
}