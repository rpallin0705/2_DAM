package com.iesvdc.acceso.excelapi;

import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class EscribeExcel {
    public static void main(String[] args) {

        XSSFWorkbook wb = new XSSFWorkbook();
        XSSFSheet hoja = wb.createSheet("Mi hoja Apache");
        XSSFRow fila = hoja.createRow(5);
        XSSFCell celda = fila.createCell(3);
        celda.setCellValue("Hola Mundo");
        XSSFCell celda2 = fila.createCell(7);
        celda2.setCellValue(3.4);

        // Para escribir en archivo excel tienes que pasarle un archivo FileOutputStream
        try (FileOutputStream fos = new FileOutputStream("borrame.xlsx")) {
            wb.write(fos);
            wb.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
