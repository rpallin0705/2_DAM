import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class Borrar {

    public static void main(String []args){
        if (args.length!=4) {
            usage();
        } else {
            if(args[0].equals("-f") && (args[2].equals("-n") || args[2].equals("-e"))){
                File carpetaContenedora = new File(args[1]);
                // System.out.println("Archivos borrados: " + encontrarArchivos(carpetaContenedora, args));
                List<String> archivosEncontrados = buscarArchivos(carpetaContenedora, args);
                System.out.println("Estos son los archivos encontrados: ");
                for (int i = 0; i < archivosEncontrados.size(); i++) {
                    System.out.println(i + ". Archivo borrado: " + archivosEncontrados.get(i));
                }

                if (elegirOpcion(archivosEncontrados.size()) == 1) {
                    System.out.println("Archivo borrado: " + archivosEncontrados.get(elegirOpcion(archivosEncontrados.size()) - 1));
                } else if (elegirOpcion(archivosEncontrados.size()) == 2) {
                    for (String archivo : archivosEncontrados) {
                        File archivoBorrado = new File(archivo);
                        archivoBorrado.delete();
                    }
                } else if (elegirOpcion(archivosEncontrados.size()) == 3) {
                    System.out.println("Saliendo...");
                }

            } else {
                usage();
            }
        }
    }

    private static Boolean encontrarArchivos(File carpetaContenedora, String[] argumentos){
        File[] contenidoCarpeta = carpetaContenedora.listFiles();
        Boolean encontrado = false;

        for (File archivoBuscado : contenidoCarpeta) {
            if (archivoBuscado.isFile() && (archivoBuscado.getName().equals(argumentos[3]) || archivoBuscado.getName().endsWith('.' + argumentos[3]))) {
                System.out.println("Archivo borrado: " + archivoBuscado.getAbsolutePath());
                archivoBuscado.delete();
                encontrado = true;
            } else if (archivoBuscado.isDirectory()) {
                encontrarArchivos(archivoBuscado, argumentos);
            }
        }

        return encontrado;
    }

    private static List<String> buscarArchivos(File carpetaContenedora, String[] argumentos){
        File[] contenidoCarpeta = carpetaContenedora.listFiles();
        List<String> archivosEncontrados = new ArrayList<>();

        for (File archivoBuscado : contenidoCarpeta) {
            if (archivoBuscado.isFile() && (archivoBuscado.getName().equals(argumentos[3]) || archivoBuscado.getName().endsWith('.' + argumentos[3]))) {
                archivosEncontrados.add(archivoBuscado.getAbsolutePath());
            } else if (archivoBuscado.isDirectory()) {
                archivosEncontrados.addAll(buscarArchivos(archivoBuscado, argumentos));
            }
        }

        return archivosEncontrados;
    }

    public static int elegirOpcion(int numArchivos){
        System.out.println("=================================================");
        System.out.println("Acciones disponibles: ");
        System.out.println("1. Borrar archivo");
        System.out.println("2. Borrar todos los archivos");
        System.out.println("3. Salir");
        System.out.println("Elige una opción: ");
        int opcion = Integer.parseInt(System.console().readLine());
        switch (opcion) {
            case 1:
                elegirArchivoABorrar(numArchivos);
                break;
            case 2:
                System.out.println("Todos los archivos borrados");
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
            default:
                System.out.println("Opción no válida");
                break;
        }

        return opcion;
    }


    private static int elegirArchivoABorrar(int numArchivos) {
        System.out.println("Elige un archivo a borrar: ");
        int indexArchivo = Integer.parseInt(System.console().readLine());
        if (indexArchivo < 0 || indexArchivo >= numArchivos) {
            System.out.println("Opción no válida");
            return elegirArchivoABorrar(numArchivos);
        }
        return indexArchivo;
    }

    private static void usage(){
        System.out.println("Uso del programa:");
        System.out.println("java Borrar -f carpeta " +
            "[-n nombre_archivo | -e extension]");
    }

   
}