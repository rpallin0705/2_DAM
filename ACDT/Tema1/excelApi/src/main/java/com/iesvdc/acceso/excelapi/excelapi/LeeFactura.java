package com.iesvdc.acceso.excelapi.excelapi;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeeFactura {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("factura.xlsx")) {
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            Sheet hoja = wb.getSheetAt(0);

            for (int i = 3; i<10; i++){
                Row row = hoja.getRow(i);
                if (row!= null) {
                    System.out.println("Leyendo fila: "+i);
                    if (row.getCell(0) != null &&
                        row.getCell(1) != null &&
                        row.getCell(2) != null) {
                            System.out.println("\t + Encontrado producto:");
                            System.out.println("\t\t- nombre: "+ row.getCell(0));
                            System.out.println("\t\t- cantidad: "+ row.getCell(1));
                            System.out.println("\t\t- importe: "+ row.getCell(2));                            
                        }
                }
            }
        } catch (IOException e) {
            System.out.println("::LeeFactura::Error: No puedo leer el archivo.");
        }
        
    }    
}
