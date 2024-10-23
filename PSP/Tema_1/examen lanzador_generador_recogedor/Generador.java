/*
* Crea un proceso ipconfig y lo manda
* a su flujo de salida.
*  @author Santiago Rodenas Herraiz
 * @version PSP 24/25
 */

import java.io.IOException;
import java.util.Scanner;


public class Generador {
    public static void main(String [] args){
        ProcessBuilder pbIC = new ProcessBuilder("ipconfig");
        
        try{
            Process pIC = pbIC.start();
            Scanner sc = new Scanner(pIC.getInputStream());
            String linea = null;

            while (sc.hasNextLine()){
                linea = sc.nextLine();
                System.out.println(linea);  //mandamos a la salida standar.
            }
            sc.close();
            pIC.waitFor();

        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        

    }
}
