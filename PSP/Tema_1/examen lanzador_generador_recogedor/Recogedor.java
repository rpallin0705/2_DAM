/*
* Lee de su flujo de entrada
* lo filtra y lo manda a su flujo de salida
*  @author Santiago Rodenas Herraiz
 * @version PSP 24/25
 */

import java.util.Scanner;

public class Recogedor {
    public static void main(String [] args){

        String linea = null;
        Scanner sc = new Scanner (System.in);
        while (sc.hasNextLine()){
            linea = sc.nextLine();
            if (linea.toLowerCase().contains("ipv4"))
                System.out.println(linea);

        }
        sc.close();
    }
}
