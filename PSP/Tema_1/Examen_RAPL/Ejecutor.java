import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Ejecutor {

	public static void main(String[] args) {

		ProcessBuilder pbGenerador = new ProcessBuilder();
		ProcessBuilder pbSumador = new ProcessBuilder();

		pbGenerador.command("javac", "Generador.java");
		pbSumador.command("javac", "Sumador.java");

		// Contador para el numero de numeros generados por generador
		int nNumerosRecibidos = 0;

		try {
			// Iniciamos Generador y Sumador Para compilar los hjava
			Process pGenerador = pbGenerador.start();
			Process pSumador = pbSumador.start();

			// Comprobamos que funciona la compilacion
			if (pGenerador.waitFor() == 1 || pSumador.waitFor() == 1) {
				System.out.println("Hubo un error de compilacion");
				System.exit(1);
			}
				
			// Cambiamos el comando para ejecutar los archivos compilados y ejecutamos el proceso
			pbGenerador.command("java", "Generador");
			pbSumador.command("java", "Sumador");
			
			pGenerador = pbGenerador.start();
			pSumador = pbSumador.start();

			// Creamos flujos de entrada y salida
			Scanner scGenerador = new Scanner(pGenerador.getInputStream()); // ??
			PrintWriter prSumador = new PrintWriter(pSumador.getOutputStream(), true);

			// Cada numero que va a devolver generador
			int numeroGenerador = 0;

			// lectura de cada numero generado
			while (scGenerador.hasNextInt()) {
				numeroGenerador = scGenerador.nextInt();
				nNumerosRecibidos++;

				// Depuracion
				System.out.println("Muestro la línea desde el Ejecutor, para test: " + numeroGenerador);

				// Salida para que la entrada de sumador reciba los numeros
				prSumador.println(numeroGenerador);

			}

			scGenerador.close();
			prSumador.close();
			// Conseguir salida de sumador

			// Para leer la salida de Sumador
			Scanner scSumador = new Scanner(pSumador.getInputStream());

			System.out.println("De un total de "
					+ nNumerosRecibidos
					+ " numeros, "
					+ scSumador.nextInt()
					+ " son pares y la suma de los pares es de "
					+ scSumador.nextInt());

			int pGId = pGenerador.waitFor();
			int pSId = pSumador.waitFor();

			if (pGId == 1 && pSId == 1)
				System.out.println("Hubo un error durante la ejecucion");
			else
				System.out.println("Todo Bien");

			scSumador.close();
			prSumador.close();

		} catch (IOException | InterruptedException e) {
			Thread.currentThread().interrupt();
			System.out.println(e.getMessage());
		}

	}
}