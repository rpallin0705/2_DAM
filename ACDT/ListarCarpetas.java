package com.iesvdc.acceso;

import java.io.File;

public class ListarCarpeta {
    public static void main(String[] args) { 
        if (args.length == 0) {
            System.out.println("No se ha pasado ningun archivo");
            System.exit(1);
        }
        String fileDirectory = args[0];
        listarCarpeta(new File(fileDirectory));
    }

    public static void listarCarpeta(File directory){
        if (directory.isDirectory()) {
            System.out.printf("Directory: %s%n", directory.getName());

            File[] listOfFiles = directory.listFiles();
            
            for (File file : listOfFiles) {
                if (file.isFile()){                   
                    System.out.printf("\tFile: %s%n", file.getPath());
                } else if (file.isDirectory()) {
                    listarCarpeta(file);
                    System.out.printf("\t");
                }
                               
            }
        }
    }
}
