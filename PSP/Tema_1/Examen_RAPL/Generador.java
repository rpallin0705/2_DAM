import java.util.Random;

public class Generador {

	public static void main(String[] args){

		Random rNNumeros = new Random();
		int nNumeros = rNNumeros.nextInt(20);
		

		for(int i = 0; i <= nNumeros; i++){
			System.out.println(rNNumeros.nextInt(101));
		}
	}
}