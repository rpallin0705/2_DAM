package com.iesvdc.acceso.app;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class LeerExcel {
    public static void main(String[] args) {
        System.out.println("Cargando libro:");
        try (FileInputStream fis = new FileInputStream("test.xlsx")){
            XSSFWorkbook wb = new XSSFWorkbook(fis);
            int nhojas= wb.getNumberOfSheets();
            // CREAR LIBRO
            Libro libro = new Libro("test1.xlsx"); 

            for (int i = 0; i < nhojas; i++) {
                XSSFSheet hojaExcel = wb.getSheetAt(i); 
                int nfilas = hojaExcel.getLastRowNum();
                short maxCol=0;
                for (int j = hojaExcel.getFirstRowNum(); j < nfilas; j++) {
                    if (maxCol < hojaExcel.getRow(j).getLastCellNum()) {
                        maxCol=hojaExcel.getRow(j).getLastCellNum();
                    }
                }
                // CREAR HOJA
                maxCol++; // si estamos en la posición maxCol, tenemos maxCol+1 columnas
                nfilas++; // si estamos en la posición nfilas, tenemos nfilas+1 filas
                Hoja hoja = new Hoja(hojaExcel.getSheetName(),nfilas,maxCol);
                hoja.fill(""); // rellenamos la hoja con la cadena vacía

                System.out.println("Estamos en la hoja: " + i 
                    + " que tiene: " + nfilas+" filas.");
                for (int j = hojaExcel.getFirstRowNum(); j < nfilas; j++) {
                    XSSFRow filaExcel = hojaExcel.getRow(j);
                    System.out.println("Estoy en la fila: " + j );
                    int nceldas = filaExcel.getLastCellNum();
                    for (int k = filaExcel.getFirstCellNum(); k < nceldas; k++) {
                        XSSFCell celdaExcel = filaExcel.getCell(k);
                        System.out.println("Contenido de la celda posición fila=" +
                           j +" col=" + k + " = " + celdaExcel.getStringCellValue());
                        // METER DATOS EN HOJA
                        hoja.setDato(celdaExcel.getStringCellValue(), j, k);
                    }
                    
                }
                libro.addHoja(hoja);
            }
            wb.close();
            libro.save();
        } catch (IOException | ExcelAPIException ex) {
            // Logger.getLogger(HolaMundoExcel.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("ERROR al crear el archivo: "+
                    ex.getLocalizedMessage());
        } finally {
            
        }
         
    }

}
