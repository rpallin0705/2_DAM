/*
 */
package com.iesvdc.acceso.excelapi.excelapi;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.streaming.SXSSFWorkbook;

/**
 * Esta clase almacena información de libros para generar ficheros de Excel.
 * Un libro se compone de hojas.
 * @author profesor
 */
public class Libro {
    private List<Hoja> hojas;
    private String nombreArchivo;

    public boolean compare(Libro copia){
        // si tienen mismo número hojas
            // para cada hoja compara this.hoja(x) con copia.hoja(x)
        if (this.hojas.size()==copia.hojas.size()){
            for (int i = 0; i < this.hojas.size(); i++) {
                if(!this.hojas.get(i).compare(copia.hojas.get(i))){
                    System.out.println("Hojas diferentes");
                    return false; // hay una hoja con datos diferentes
                }
            }
        } else {
            System.out.println("Distinto número de hojas");
            return false; // distinto número de hojas
        }
        System.out.println("Libros iguales");
        return true; // todas las hojas con mismo nombre y contenido
    }

    public Libro() {
        this.hojas = new ArrayList<>();
        this.nombreArchivo = "nuevo.xlsx";
    }

    public Libro(String nombreArchivo) {
        this.hojas = new ArrayList<>();
        this.nombreArchivo = nombreArchivo;
    }

    public String getNombreArchivo() {
        return nombreArchivo;
    }

    public void setNombreArchivo(String nombreArchivo) {
        this.nombreArchivo = nombreArchivo;
    }
    
    public boolean addHoja(Hoja hoja){
        return this.hojas.add(hoja);
    }
            
    public Hoja removeHoja(int index) throws ExcelAPIException{
        if(index<0 || index>this.hojas.size()) {
            throw new ExcelAPIException("Libro::removeHoja(): Posición no válida.");
        }
        return this.hojas.remove(index);
    }
            
    public Hoja indexHoja(int index) throws ExcelAPIException{
        if(index<0 || index>this.hojas.size()) {
            throw new ExcelAPIException("Libro::indexHoja(): Posición no válida.");
        }
        return this.hojas.get(index);
    }
    
    public void load(){
                        
    }
    
    public void load(String filename){
        this.nombreArchivo = filename;
        this.load();
    }
    
    public void save() throws ExcelAPIException{
        // Libro excel
        SXSSFWorkbook wb = new SXSSFWorkbook();
        // this es "mi libro"
        for (Hoja hoja: this.hojas) {
            Sheet sh = wb.createSheet(hoja.getNombre());
            for (int i = 0; i < hoja.getFilas(); i++) {
                Row row = sh.createRow(i);
                for (int j = 0; j < hoja.getColumnas(); j++) {
                    Cell cell = row.createCell(j);
                    cell.setCellValue(hoja.getDato(i, j));                
                }
            }
        }
        try (FileOutputStream out = new FileOutputStream(this.nombreArchivo)){            
            wb.write(out);
            wb.close();
        } catch (IOException ex) {
            throw new ExcelAPIException("Error al guardar el archivo");
        } finally {
            wb.dispose();
        }
        
    }
    
    public void save(String filename) throws ExcelAPIException{
        this.nombreArchivo = filename;
        this.save();
    }
    
}













