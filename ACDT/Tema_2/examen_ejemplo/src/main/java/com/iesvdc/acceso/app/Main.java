package com.iesvdc.acceso.app;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.iesvdc.acceso.app.model.Vehiculo;
import com.iesvdc.acceso.app.service.VehiculoService;

public class Main {
    public static void main(String[] args) {
        
        VehiculoService vehiculoService = new VehiculoService();


        try (FileInputStream fis = new FileInputStream("data.xlsx")){

            XSSFWorkbook wb = new XSSFWorkbook(fis);
            
            Sheet sheet = wb.getSheetAt(0);
            
            Vehiculo vh = new Vehiculo();

            for (int i = 2; i < 15; i++) {
                Row row = sheet.getRow(i);
                
                vh.marca(row.getCell(1).getStringCellValue())
                    .modelo(row.getCell(2).getStringCellValue())
                    .anio((int)row.getCell(3).getNumericCellValue())
                    .precio(row.getCell(4).getNumericCellValue())
                    .combustible(row.getCell(5).getStringCellValue());
                    
                vehiculoService.save(vh);
            }

        }catch (IOException e){
            e.getMessage();
        }
    }

    // private static void cargarDatos() {
    //     try (FileInputStream fis = new FileInputStream("data.xlsx")){

    //         XSSFWorkbook wb = new XSSFWorkbook(fis);
            
    //         Sheet sheet = wb.getSheetAt(0);
            
    //         Vehiculo vh = new Vehiculo();

    //         for (int i = 2; i < 15; i++) {
    //             Row row = sheet.getRow(i);
                
    //             vh.marca(row.getCell(2).toString())
    //                 .modelo(row.getCell(3).getStringCellValue())
    //                 .anio(((int)row.getCell(3).getNumericCellValue()))
    //                 .modelo(row.getCell(4).getStringCellValue())
    //                 .modelo(row.getCell(5).getStringCellValue());
                    

    //         }

    //     }catch (IOException e){
    //         e.getMessage();
    //     }
    // }
}
