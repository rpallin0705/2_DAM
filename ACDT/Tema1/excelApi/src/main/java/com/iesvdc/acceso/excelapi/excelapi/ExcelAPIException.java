/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.iesvdc.acceso.excelapi.excelapi;

/**
 *
 * @author profesor
 */
public class ExcelAPIException extends Exception {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    /**
     * Creates a new instance of <code>ExcelAPIException</code> without detail
     * message.
     */
    public ExcelAPIException() {
    }

    /**
     * Constructs an instance of <code>ExcelAPIException</code> with the
     * specified detail message.
     *
     * @param msg the detail message.
     */
    public ExcelAPIException(String msg) {
        super("ExcelAPIException::"+msg);
    }
}







