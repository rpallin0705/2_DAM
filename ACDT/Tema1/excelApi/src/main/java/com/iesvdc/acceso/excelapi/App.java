package com.iesvdc.acceso.excelapi;

import java.io.File;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class App {
    public static void main(String[] args) {
        try (XSSFWorkbook wb = new XSSFWorkbook(new File("test2.xlsx"))) {

            int nHojas = wb.getNumberOfSheets();

            // Este for es para las filas
            for (int i = 0; i < nHojas; i++) {
                XSSFSheet hoja = wb.getSheetAt(i);
                System.out.println("Estamos en la hoja: " + hoja.getSheetName());
                int primeraFila = hoja.getFirstRowNum();
                int ultimaFila = hoja.getLastRowNum();
                // Este es para las columnas
                for (int j = primeraFila; j <= ultimaFila; j++) {
                    System.out.println("\tEstamos en la fila " + j);
                    XSSFRow fila = hoja.getRow(j);
                    if (fila != null) {
                        // // Hay que guardar el iterador en una variable Iterator para que el bucle no
                        // sea
                        // // infinito
                        // // y el hasNext haga avanzar al iterador
                        // Iterator<Cell> iterador = fila.cellIterator();
                        // while (iterador.hasNext()) {
                        // Cell celda = iterador.next();

                        // System.out.println("\t\tEstamos en la celda " + celda.getColumnIndex() +
                        // " Que contiene " +
                        // celda.getStringCellValue());
                        // }
                        // } else {
                        // System.out.println("\t\t !! VACIA ¡¡");
                        // }

                        int primeraCelda = fila.getFirstCellNum();
                        int ultimaCelda = fila.getLastCellNum();

                        for (int k = primeraCelda; k < ultimaCelda; k++) {
                            Cell celda = fila.getCell(k);
                            if (celda != null) {
                                System.out.println("\t\tEstamos en la celda : "
                                        + celda.getColumnIndex()
                                        + " Que contiene "
                                        + celda.getStringCellValue());
                            } else {
                                System.out.println("\t\t ¡¡ Está vacía !!");
                            }

                        }
                    }
                }
            }
        } catch (IOException ioe) {
            System.out.println(ioe.getMessage());
        } catch (InvalidFormatException ife) {
            System.out.println(ife.getMessage());
        }
    }
}
