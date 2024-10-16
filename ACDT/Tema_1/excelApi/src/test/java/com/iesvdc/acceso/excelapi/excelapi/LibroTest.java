/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.excelapi.excelapi;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author profesor
 */
public class LibroTest {

    public LibroTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getNombreArchivo method, of class Libro.
     */
    @Test
    public void testGetNombreArchivo() {
        System.out.println("getNombreArchivo");
        Libro instance = new Libro();
        String expResult = "nuevo.xlsx";
        String result = instance.getNombreArchivo();
        assertEquals(expResult, result);
    }

    /**
     * Test of setNombreArchivo method, of class Libro.
     */
    @Test
    public void testSetNombreArchivo() {
        System.out.println("setNombreArchivo");
        String nombreArchivo = "unNombre.xlsx";
        Libro instance = new Libro();
        instance.setNombreArchivo(nombreArchivo);
        assertEquals(nombreArchivo, instance.getNombreArchivo());
    }

    /**
     * Test of addHoja method, of class Libro.
     */
    @Test
    public void testAddHoja() {
        System.out.println("addHoja");

        int filas = 20, columnas = 30;
        Hoja hoja = new Hoja("pepe", filas, columnas);

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                hoja.setDato((char) ('A' + j) + " " + (i + 1), i, j);
            }
        }
        Libro instance = new Libro();
        instance.addHoja(hoja);
        try {
            assertEquals(instance.indexHoja(0).compare(hoja), true);
        } catch (ExcelAPIException ex) {
            fail("No pude acceder a la hoja");
        }
    }

    /**
     * Test of removeHoja method, of class Libro.
     */
    @Test
    public void testRemoveHoja() throws Exception {
        System.out.println("removeHoja");
        int index = 0;

        Libro instance = new Libro("nuevo_libro.xlsx");
        Hoja expResult = new Hoja("Hoja 1", 5, 5);
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                expResult.setDato((char) ('A' + j) + " " + (i + 1), i, j);
            }
        }
        instance.addHoja(expResult);

        Hoja result = instance.removeHoja(index);

        assertEquals("Error en removeHoja():", result.compare(expResult), true);

    }

    /**
     * Test of save method, of class Libro.
     */
    @Test
    public void testSave_0args() throws Exception {
        System.out.println("save");
        Libro instance = new Libro("test.xlsx");
        Hoja h1 = new Hoja("Hoja 1", 6, 6);
        Hoja h2 = new Hoja("Hoja 2", 10, 10);
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                h1.setDato((char) ('A' + j) + " " + (i + 1), i, j);
            }
        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                h2.setDato((char) ('A' + j) + " " + (i + 1), i, j);
            }
        }
        instance.addHoja(h1);
        instance.addHoja(h2);
        instance.save();

        // volvemos a cargar el libro generado
        Libro copia = new Libro();
        copia.load("test2.xlsx");
        
        System.out.println("holaAAAA " + instance.compare(copia));

        // comparamos la copia con el original
        assertEquals(true, instance.compare(copia));
    }

    /**
     * ESte test genera un libro, lo guarda en un archivo,
     * lo lee de nuevo y compara los resultados
     */
    @Test
    public void generaGuardarCargarComparaLibro() {
        Libro libro = new Libro("borrame.xlsx");

        Hoja hoja = new Hoja("Primera hoja", 10, 10);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                hoja.setDato("(" + i + "," + j + ")", i, j);
            }
        }

        libro.addHoja(hoja);

        try {
            libro.save();
        } catch (ExcelAPIException e) {
            assertFalse(false);
        }

        Libro libro2 = new Libro();
        libro2.load("borrame.xlsx");
        assertEquals(libro, libro2);

    }

    
    

}
