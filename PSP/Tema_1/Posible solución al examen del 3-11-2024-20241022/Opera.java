import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class Opera {
    static final String COMMAND = "java";
    static final String OPTION = "-cp";
    static final String FILE_JAR = "realiza.jar";
    static final String FILE_CLASS = "RealizaOperacion";
    static final String COMMAND_JAR = "jar";
    static final String OPTIONS_JAR = "cf";
    
    public static void main(String[] args) {
       
        String [] parameters = {COMMAND, OPTION, FILE_JAR, FILE_CLASS};
        String [] parametersJar = {COMMAND_JAR, OPTIONS_JAR, FILE_JAR, FILE_CLASS+".class"};
       

        ProcessBuilder pbJar = new ProcessBuilder(parametersJar);
        try{
            Process pJar = pbJar.start();
            try{
                int codRet = pJar.waitFor();
                if(codRet != 0){
                    System.exit(-1);
                }
            }catch(InterruptedException e){
                e.printStackTrace();
            }

            System.out.print("Introducir Operacion Formato (+|-|*|:) (entero) (entero)> ");
            String line = new Scanner(System.in).nextLine();
            ProcessBuilder pb = new ProcessBuilder(parameters);

            Process p = pb.start();
            PrintWriter pw = new PrintWriter(p.getOutputStream());
            pw.println(line);
            pw.close();

            try{
                int codRet = p.waitFor();
                System.out.print((codRet == 0 ? "Ejecución del subproceso correctamente: " : "Error") );
            }catch(InterruptedException e){
                e.printStackTrace();
            }

           
            BufferedReader br = new BufferedReader(
                new InputStreamReader(p.getInputStream())
                );

            String resulLine = br.readLine();
            System.out.println(resulLine);

            br.close();

        }catch(IOException e){
            e.printStackTrace();
        }
    
    }


    
}
