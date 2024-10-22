import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RealizaOperacion {
    static final  String REGEX = "(\\+|\\-|\\*|\\:)\\s+(\\d+)\\s+(\\d+)$";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //System.out.println("Introducir operacion");
        String cad = input.nextLine();
        Pattern pat = Pattern.compile(REGEX);
        Matcher mat = pat.matcher(cad);
        String sal="";
        if (mat.find()){
            
            //System.out.println(operation+" "+ope1+" "+ope2);
           
            String operation = mat.group(1);
            int ope1 = Integer.parseInt(mat.group(2));
            int ope2 = Integer.parseInt(mat.group(3));
            
            switch (operation) {
                case "+":
                    sal = "Resultado = "+ (ope1 + ope2);
                    break;
                case "-":
                    sal = "Resultado = "+ (ope1 - ope2);
                    break;
                case "*":
                    sal = "Resultado = "+ (ope1 * ope2);
                    break;
                default:
                    if(ope2 == 0)
                        sal= "Error división por 0";
                    else
                        sal = "Resultado = "+ (ope1 / ope2);
                    break;
            }
          //  System.out.println(sal);
            
        }else{
            sal = "Error en los parámetros"; 
        }
        System.out.println(sal);
      
    }

}
