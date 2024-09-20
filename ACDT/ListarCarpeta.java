package com.iesvdc.acceso;

import java.io.File;

public class ListarCarpeta {
    public static void main(String[] args) { 
        if (args.length == 0) {
            System.out.println("No se ha pasado ningun archivo");
            System.exit(1);
        }
        String fileDirectory = args[0];
        listarCarpeta(new File(fileDirectory), 0);
    }

    public static void listarCarpeta(File directory, int nivel){
        if (directory.isDirectory()) {
            System.out.printf("%s%s%s%n","\t".repeat(nivel),"Directory: ", directory.getName());

            File[] listOfFiles = directory.listFiles();
            
            for (File file : listOfFiles) {
                if (file.isFile())             
                    System.out.printf("%s%s%n", "\t".repeat(nivel + 1), file.getName());
                else if (file.isDirectory())
                    listarCarpeta(file, nivel + 1);              
            }
        }
    }
}
