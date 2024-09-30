package com.iesvdc.acceso;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Random;

import com.iesvdc.acceso.model.Persona;

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

        // try {
        // System.out.println(gPersonas.generarPersonas(5).toString());
        // } catch (Exception e) {
        // System.err.println(e.getMessage());
        // }

        System.out.println(generarFecha());
    }

    public static LocalDate generarFecha(){
        // Almacenamos en una variable "startingDate" () pasamos a formato UNIX la fecha 1/1/1920
        LocalDate startingDate = LocalDate.of(1920, 1, 1);
        Long startingDateUnix = startingDate.toEpochDay(); 
        // Almacenamos en una variable "endingDate" (pasamos a formato UNIX la fecha actual)
        LocalDate endingDate = LocalDate.now();
        Long endingDateUnix = endingDate.toEpochDay();
        // Restamos endingDate - startingDate y generamos un número aleatorio entre 0 y la diferencia de las fechas.
        Long randomDate = new Random().nextLong(endingDateUnix - startingDateUnix);
        // Pasamos el numero aleatorio a localDate
        return LocalDate.ofEpochDay(randomDate + startingDateUnix);
        
    }
}
