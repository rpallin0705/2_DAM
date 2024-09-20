import java.io.File;

public class BorrarMascotas {
    public static void main(String[] args) {
        File fileToDelete = new File("mascotas.dat");

        if(fileToDelete.exists() || fileToDelete.isFile()){
            System.out.printf("Borrando archivo %s en directorio %s...%n", fileToDelete.getName(), fileToDelete.getPath());
            if (fileToDelete.delete())
                System.out.printf("Archivo %s borrado", fileToDelete.getName());
            else
                System.out.println("No se pudo eliminar el archivo");             
        } else {
            System.out.println("No existe el archivo");
        }
    }
}
