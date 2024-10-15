package com.iesvdc.acceso.marshallers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.iesvdc.acceso.model.Proyecto;



public class MarshallerXML {
    public static void marshallXML(Proyecto proyecto) {
     
       try {
           // Creamos una instancia de JAXBContext
           JAXBContext jbcd = JAXBContext.newInstance(proyecto.getClass());
           // Creamos un marshaller y le indicamos el formato de salida
           Marshaller marshaller = jbcd.createMarshaller();
           
           // Creado del fichero con los datos
           marshaller.marshal(proyecto, new File("data/proyectoAXML.xml"));

       } catch (JAXBException e) {
           System.err.println(e.getMessage());
       }
   }
}
