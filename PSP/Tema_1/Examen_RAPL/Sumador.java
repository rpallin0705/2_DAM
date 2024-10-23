import java.util.Scanner;

public class Sumador {
	public static void main(String[] args) {

		Scanner scSumador = new Scanner(System.in);

		int numeroASumar = 0;
		int numerosPares = 0;
		int sumaPares = 0;

		while (scSumador.hasNextInt()) {
			numeroASumar= scSumador.nextInt();
			if (numeroASumar % 2 == 0) {
				sumaPares += numeroASumar;
				numerosPares++;
			}
		}

		System.out.println(numerosPares);
		System.out.println(sumaPares);

	}
}