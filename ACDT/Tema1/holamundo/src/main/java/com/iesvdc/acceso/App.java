package com.iesvdc.acceso;

import com.iesvdc.acceso.error.LoadDataException;
import com.iesvdc.acceso.model.Personas;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        Personas gPersonas = new Personas();
        gPersonas.loadData(
                "datos\\nombres-mujer.txt",
                "datos\\nombres-hombre.txt",
                "datos\\apellidos.txt");

        try {
            gPersonas.generarPersonas(100);
            System.out.println(gPersonas.getListaPersonas().toString());
        } catch (LoadDataException e) {
            System.err.println(e.getMessage());
        }

    }
}
