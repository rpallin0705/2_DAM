package com.iesvdc.acceso.error;

public class DniException extends Exception{
       public DniException(String message) {
        super(message);
    }

    public DniException(String message, Throwable cause) {
        super(message, cause);
    }
}
