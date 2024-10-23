import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {

        try (Scanner scLectura = new Scanner(System.in);) {

            String linea = "";
            System.out.println("Introduce la cadena que quieras convertir a mayusculas (presiona enter para salir)");
            do {
                linea = scLectura.nextLine();

                if (linea.isEmpty()) {
                    System.out.println("Saliendo del programa");
                    System.exit(1);
                }

            } while (linea.isEmpty());

            ProcessBuilder pb = new ProcessBuilder("java", "ConversorMayúsculas");
            Process pMayusculas = pb.start();

            PrintWriter prMay = new PrintWriter(pMayusculas.getOutputStream(), true);
            Scanner scMayusculas = new Scanner(pMayusculas.getInputStream());

            prMay.println(linea);
            prMay.close();

            while (scMayusculas.hasNextLine()) {
                linea = scMayusculas.nextLine();
                System.out.println(linea);
            }

            scMayusculas.close();

            pMayusculas.waitFor();

        } catch (IOException | InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }
}
