package com.iesvdc.acceso.inventario.conexion;

public class Prueba {
    public static void main(String[] args) {
        Conexion conexion = new Conexion();

        conexion.createDatabase().leerArchivoDatabase();
   
        
    }
}
