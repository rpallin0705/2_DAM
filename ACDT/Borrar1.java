import java.io.File;

public class Borrar1 {

    public static void main(String []args){
        if (args.length!=4) {
            usage();
        } else {
            if(args[0].equals("-f") && (args[2].equals("-n") || args[2].equals("-e"))){
                File carpetaContenedora = new File(args[1]);
                System.out.println("Archivos borrados: " + encontrarArchivos(carpetaContenedora, args));
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

    private static void usage(){
        System.out.println("Uso del programa:");
        System.out.println("java Borrar -f carpeta " +
            "[-n nombre_archivo | -e extension]");
    }

   
}