package com.iesvdc.acceso;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        GeneradorPersonas gPersonas = new GeneradorPersonas();
        gPersonas.loadData(
                "datos\\nombres-mujer.txt",
                "datos\\nombres-hombre.txt",
                "datos\\apellidos.txt");

        try {
            System.out.println(gPersonas.generarPersonas(10).toString());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

    }
}
