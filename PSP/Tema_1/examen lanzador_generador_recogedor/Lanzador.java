/**
 * Clase principal para ejecutar el programa Lanzador.
 * Este programa lanza los procesos Generador y Recogedor,
 * utilizando los flujos E/S de los procesos, con getInputStream
 * y con getOutputStream. Es más largo, pero muy detallado.
 * 
 * Lanza ambos procesos
 * Recupera de Generador el ipconfig
 * Manda a Recogedor lo que recibe del ipconfig
 * Recogedor hereda la salida de Lanzador y por eso lo vemos en pantalla
 * de Lanzador.
 * 
 * 
 * @author Santiago Rodenas Herraiz
 * @version PSP 24/25
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Lanzador {
    public static void main(String [] args){

        ProcessBuilder pbGen = new ProcessBuilder();
        ProcessBuilder pbRec = new ProcessBuilder();

        pbGen.command(new String [] {"java" , "Generador"});
        pbRec.command(new String [] {"java", "Recogedor"});

        pbRec.redirectOutput(ProcessBuilder.Redirect.INHERIT); //hereda la salida del padre.
        try{
            Process pGen = pbGen.start();   //lanzo Generador
            Process pRec = pbRec.start();   //lanzo Recogedor

            //Quiero un flujo de entrada, que conecte con la salida de pGen
            Scanner scannerGen = new Scanner (pGen.getInputStream());
            //Quiero un flujo de salida que conecte con la entrada de Recogedor
            PrintWriter pwRec = new PrintWriter(pRec.getOutputStream());
          
            String linea = null;
            while (scannerGen.hasNextLine()){
                linea = scannerGen.nextLine(); //leemos de generador
                pwRec.println(linea);
                pwRec.flush();  //me aseguro que se envíen inmediatamente.
              //System.out.println(linea);
            }
            pwRec.close();
            scannerGen.close();

            int codGen = pGen.waitFor();
            int codRec = pRec.waitFor();

            String salida = (codGen == 0 && codRec == 0) ? "Todo bien" : "Ejecución errónea";
            System.out.println (salida);

        }catch (IOException e){
            e.printStackTrace();
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        
    }
}