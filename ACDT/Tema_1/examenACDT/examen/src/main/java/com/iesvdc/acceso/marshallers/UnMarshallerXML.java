package com.iesvdc.acceso.marshallers;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import com.iesvdc.acceso.model.Proyecto;


/**
 * Ejemplo de unmarshaller de personas. 
 * Versión XML.
 */
public class UnMarshallerXML 
{
    public static Proyecto UnMarshallXML( String archivoXML )


    {
        Proyecto proyecto = new Proyecto();
        JAXBContext jaxbContext;

        try {
            
            jaxbContext = JAXBContext.newInstance(proyecto.getClass());
            Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
            Object objeto = jaxbUnmarshaller.unmarshal(new File("data/" + archivoXML));
            proyecto = (Proyecto) objeto;
            System.out.println(proyecto);

        } catch (JAXBException e) {
            System.err.println(e.getMessage());
        }

        return proyecto;
        
    }
}