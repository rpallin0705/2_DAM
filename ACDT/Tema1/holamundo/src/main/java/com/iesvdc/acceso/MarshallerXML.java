package com.iesvdc.acceso;

import java.io.File;

import com.iesvdc.acceso.error.LoadDataException;
import com.iesvdc.acceso.model.Personas;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;

public class MarshallerXML {
     public static void main(String[] args) {
        Personas gPersonas = new Personas();
        gPersonas.loadData(
                "datos\\nombres-mujer.txt",
                "datos\\nombres-hombre.txt",
                "datos\\apellidos.txt");

        try {
            gPersonas.generarPersonas(100);
            // Creamos una instancia de JAXBContext
            JAXBContext jbcd = JAXBContext.newInstance(gPersonas.getClass());
            // Creamos un marshaller y le indicamos el formato de salida
            Marshaller marshaller = jbcd.createMarshaller();
            
            // Creado del fichero con los datos
            marshaller.marshal(gPersonas, new File("datos\\personas.xml"));

        } catch (LoadDataException | JAXBException e) {
            System.err.println(e.getMessage());
        }
    }
}