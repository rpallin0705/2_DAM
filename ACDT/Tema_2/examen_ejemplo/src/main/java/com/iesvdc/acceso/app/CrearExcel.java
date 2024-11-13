package com.iesvdc.acceso.app;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.streaming.SXSSFRow;
import org.apache.poi.xssf.streaming.SXSSFSheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

public class CrearExcel {

    public static void main(String[] args) throws IOException {

        SXSSFWorkbook wb = new SXSSFWorkbook();

        SXSSFSheet sh = wb.createSheet("HOLA MUNDO");

        for (int i = 0; i < 10; i++) {
            SXSSFRow row = sh.createRow(i);
            for (int j = 0; j < 10; j++) {
                Cell cell = row.createCell(j);
                cell.setCellValue((char) ('A' + j) + " " + (i + 1));
            }
        }

        try (FileOutputStream out = new FileOutputStream("holaMundoExcel.xlsx")) {
            wb.write(out);
        } catch (IOException ex) {
            System.out.println("ERROR al crear el archivo: " +
                    ex.getLocalizedMessage());
        } finally {
            wb.close();
        }

    }
}
