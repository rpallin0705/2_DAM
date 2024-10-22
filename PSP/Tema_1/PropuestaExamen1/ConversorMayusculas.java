import java.util.Scanner;

public class ConversorMayusculas {
    public static void main(String[] args) {
        String lineaAConvertir = "";
        Scanner sc = new Scanner(System.in);
        
        lineaAConvertir = sc.nextLine();
        System.out.println(lineaAConvertir.toUpperCase());
        sc.close();
    }
}
